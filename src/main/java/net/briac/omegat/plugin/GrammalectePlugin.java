/**************************************************************************
 OmegaT - Computer Assisted Translation (CAT) tool
          with fuzzy matching, translation memory, keyword search,
          glossaries, and translation leveraging into updated projects.

 Copyright (C) 2019 Briac Pilpre
               Home page: http://www.omegat.org/
               Support center: http://groups.yahoo.com/group/OmegaT/

 This file is part of OmegaT.

 OmegaT is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 OmegaT is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.
 **************************************************************************/
package net.briac.omegat.plugin;

import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javax.swing.text.Highlighter.HighlightPainter;

import org.apache.commons.io.IOUtils;
import org.omegat.core.Core;
import org.omegat.core.CoreEvents;
import org.omegat.core.data.SourceTextEntry;
import org.omegat.core.data.TMXEntry;
import org.omegat.core.events.IApplicationEventListener;
import org.omegat.gui.editor.UnderlineFactory;
import org.omegat.gui.editor.mark.IMarker;
import org.omegat.gui.editor.mark.Mark;
import org.omegat.gui.issues.IIssue;
import org.omegat.gui.issues.IIssueProvider;
import org.omegat.gui.issues.IssueProviders;
import org.omegat.gui.preferences.PreferencesControllers;
import org.omegat.util.JsonParser;
import org.omegat.util.Log;
import org.omegat.util.OStrings;
import org.omegat.util.Preferences;
import org.omegat.util.StringUtil;
import org.omegat.util.gui.Styles;

public class GrammalectePlugin implements IIssueProvider, IMarker {
    protected static final ResourceBundle res = ResourceBundle.getBundle("plugin-grammalecte", Locale.getDefault());
    private static final String API_VERSION = "1.5.0";
    private static final String GRAMMALECTE_SERVER_URL = "grammalecte-serverUrl";
    public static final String DEFAULT_URL = "http://localhost:8080/gc_text/fr";

    static final HighlightPainter PAINTER = new UnderlineFactory.WaveUnderline(
            Styles.EditorColor.COLOR_LANGUAGE_TOOLS.getColor().brighter());

    static {
        Core.registerMarker(new GrammalectePlugin());
    }

    public static void loadPlugins() {

        CoreEvents.registerApplicationEventListener(new IApplicationEventListener() {
            @Override
            public void onApplicationStartup() {
                PreferencesControllers.addSupplier(GrammalectePrefsController::new);
                IssueProviders.addIssueProvider(new GrammalectePlugin());
            }

            @Override
            public void onApplicationShutdown() {
                /* empty */
            }
        });
    }

    public static void unloadPlugins() {
        /* empty */
    }

    @Override
    public String getId() {
        return getClass().getCanonicalName();
    }

    @Override
    public String getName() {
        return res.getString("GRAMMALECTE_PROVIDER_NAME");
    }

    @Override
    public List<IIssue> getIssues(SourceTextEntry sourceEntry, TMXEntry tmxEntry) {
        try {
            return getCheckResults(sourceEntry.getSrcText(), tmxEntry.translation).stream()
                    .map(match -> new GrammalecteIssue(sourceEntry, tmxEntry.translation, match))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @SuppressWarnings("unchecked")
    protected List<GrammalecteResult> getCheckResults(String sourceText, String translationText) throws Exception {
        String targetLang = Core.getProject().getProjectProperties().getTargetLanguage().getLanguageCode();
        String serverUrl = Preferences.getPreferenceDefault(GRAMMALECTE_SERVER_URL, DEFAULT_URL);

        if (targetLang == null || !targetLang.equalsIgnoreCase("fr")) {
            return Collections.emptyList();
        }

        URL url = new URL(serverUrl);
        URLConnection conn = url.openConnection();
        conn.setRequestProperty("User-Agent", OStrings.getNameAndVersion());
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setDoOutput(true);
        try (OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream(), StandardCharsets.UTF_8)) {
            String encoding = "UTF-8";
            StringBuilder sb = new StringBuilder("text=");

            // Eliza - remove "_" an "*"
            translationText = translationText.replaceAll("[_*]", "");

            sb.append(URLEncoder.encode(translationText, encoding));

            boolean isTextFormatter = false;
            if (isTextFormatter) {
                sb.append("&tf=").append("on");
            }

            sb.append("&options=").append(URLEncoder.encode(jsonOption(), encoding));

            writer.write(sb.toString());
            writer.flush();
        }

        String json = "";
        try (InputStream in = conn.getInputStream()) {
            json = IOUtils.toString(in, StandardCharsets.UTF_8);
        }

        Map<String, Object> response = (Map<String, Object>) JsonParser.parse(json);

        String apiVersion = String.valueOf(response.get("version"));

        if (!API_VERSION.equals(apiVersion)) {
            Log.log("Grammalecte version mismatch");
        }

        List<Map<String, Object>> data = (List<Map<String, Object>>) response.get("data");
        return data.stream().flatMap(d -> ((List<Map<String, Object>>) d.get("lGrammarErrors")).stream()).map(error -> {
            String message = error.get("sMessage").toString();
            String ruleId = error.get("sRuleId").toString();
            int start = Integer.parseInt(error.get("nStart").toString());
            int end = Integer.parseInt(error.get("nEnd").toString());

            List<String> suggestions = (List<String>) error.get("aSuggestions");

            return new GrammalecteResult(message, start, end, ruleId, suggestions);

        }).collect(Collectors.toList());
    }

    private String jsonOption() {
        StringBuilder sb = new StringBuilder("{");
        // TODO - be smarter and send only nondefaults options?
        //        or better, use POST {server_url}/set_options/fr
        sb.append("\"apos\":").append(Preferences.isPreference("grammalecte-Apos")).append(",");
        sb.append("\"bs\":").append(Preferences.isPreference("grammalecte-Bs")).append(",");
        sb.append("\"chim\":").append(Preferences.isPreference("grammalecte-Chim")).append(",");
        sb.append("\"conf\":").append(Preferences.isPreference("grammalecte-Conf")).append(",");
        sb.append("\"conj\":").append(Preferences.isPreference("grammalecte-Conj")).append(",");
        sb.append("\"date\":").append(Preferences.isPreference("grammalecte-Date")).append(",");
        sb.append("\"eepi\":").append(Preferences.isPreference("grammalecte-Eepi")).append(",");
        sb.append("\"esp\":").append(Preferences.isPreference("grammalecte-Esp")).append(",");
        sb.append("\"gn\":").append(Preferences.isPreference("grammalecte-Gn")).append(",");
        sb.append("\"imp\":").append(Preferences.isPreference("grammalecte-Imp")).append(",");
        sb.append("\"infi\":").append(Preferences.isPreference("grammalecte-Infi")).append(",");
        sb.append("\"inte\":").append(Preferences.isPreference("grammalecte-Inte")).append(",");
        sb.append("\"liga\":").append(Preferences.isPreference("grammalecte-Liga")).append(",");
        sb.append("\"maj\":").append(Preferences.isPreference("grammalecte-Maj")).append(",");
        sb.append("\"mapos\":").append(Preferences.isPreference("grammalecte-Mapos")).append(",");
        sb.append("\"mc\":").append(Preferences.isPreference("grammalecte-Mc")).append(",");
        sb.append("\"nbsp\":").append(Preferences.isPreference("grammalecte-Nbsp")).append(",");
        sb.append("\"neg\":").append(Preferences.isPreference("grammalecte-Neg")).append(",");
        sb.append("\"nf\":").append(Preferences.isPreference("grammalecte-Nf")).append(",");
        sb.append("\"num\":").append(Preferences.isPreference("grammalecte-Num")).append(",");
        sb.append("\"ocr\":").append(Preferences.isPreference("grammalecte-Ocr")).append(",");
        sb.append("\"pleo\":").append(Preferences.isPreference("grammalecte-Pleo")).append(",");
        sb.append("\"poncfin\":").append(Preferences.isPreference("grammalecte-Poncfin")).append(",");
        sb.append("\"ppas\":").append(Preferences.isPreference("grammalecte-Ppas")).append(",");
        sb.append("\"redon1\":").append(Preferences.isPreference("grammalecte-Redon1")).append(",");
        sb.append("\"redon2\":").append(Preferences.isPreference("grammalecte-Redon2")).append(",");
        sb.append("\"sgpl\":").append(Preferences.isPreference("grammalecte-Sgpl")).append(",");
        sb.append("\"tab\":").append(Preferences.isPreference("grammalecte-Tab")).append(",");
        sb.append("\"tu\":").append(Preferences.isPreference("grammalecte-Tu")).append(",");
        sb.append("\"typo\":").append(Preferences.isPreference("grammalecte-Typo")).append(",");
        sb.append("\"unit\":").append(Preferences.isPreference("grammalecte-Unit")).append(",");
        sb.append("\"virg\":").append(Preferences.isPreference("grammalecte-Virg")).append(",");
        sb.append("\"vmode\":").append(Preferences.isPreference("grammalecte-Vmode"));
        sb.append("}");
        return sb.toString();
    }

    @Override
    public List<Mark> getMarksForEntry(SourceTextEntry ste, String sourceText, String translationText, boolean isActive)
            throws Exception {
        if (translationText == null) {
            // Return when disabled or translation text is empty
            return null;
        }

        translationText = StringUtil.normalizeUnicode(translationText);
        sourceText = ste.getSrcText();

        return getCheckResults(sourceText, translationText).stream().map(match -> {
            Mark m = new Mark(Mark.ENTRY_PART.TRANSLATION, match.start, match.end);
            m.toolTipText = match.message;
            m.painter = PAINTER;
            return m;
        }).collect(Collectors.toList());
    }

//    protected boolean isEnabled() {
//        return Core.getEditor().getSettings().isMarkLanguageChecker();
//    }

}
