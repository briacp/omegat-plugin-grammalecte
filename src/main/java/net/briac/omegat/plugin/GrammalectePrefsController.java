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

import javax.swing.JComponent;

import org.omegat.gui.preferences.BasePreferencesController;
import org.omegat.util.Preferences;

/**
 *
 * @author briac
 */
public class GrammalectePrefsController extends BasePreferencesController {

    private GrammalectePrefsPanel panel;

    @Override
    public JComponent getGui() {
        if (panel == null) {
            initGui();
            initFromPrefs();
        }
        return panel;
    }

    @Override
    public String toString() {
        return GrammalectePlugin.res.getString("GRAMMALECTE_ISSUE_NAME");
    }

    private void initGui() {
        panel = new GrammalectePrefsPanel();
    }

    @Override
    public void persist() {
        Preferences.setPreference("grammalecte-serverUrl", panel.fieldUrl.getText());
        Preferences.setPreference("grammalecte-Apos", panel.prefApos.isSelected());
        Preferences.setPreference("grammalecte-Bs", panel.prefBs.isSelected());
        Preferences.setPreference("grammalecte-Chim", panel.prefChim.isSelected());
        Preferences.setPreference("grammalecte-Conf", panel.prefConf.isSelected());
        Preferences.setPreference("grammalecte-Conj", panel.prefConj.isSelected());
        Preferences.setPreference("grammalecte-Date", panel.prefDate.isSelected());
        Preferences.setPreference("grammalecte-Eepi", panel.prefEepi.isSelected());
        Preferences.setPreference("grammalecte-Esp", panel.prefEsp.isSelected());
        Preferences.setPreference("grammalecte-Gn", panel.prefGn.isSelected());
        Preferences.setPreference("grammalecte-Imp", panel.prefImp.isSelected());
        Preferences.setPreference("grammalecte-Infi", panel.prefInfi.isSelected());
        Preferences.setPreference("grammalecte-Inte", panel.prefInte.isSelected());
        Preferences.setPreference("grammalecte-Liga", panel.prefLiga.isSelected());
        Preferences.setPreference("grammalecte-Maj", panel.prefMaj.isSelected());
        Preferences.setPreference("grammalecte-Mapos", panel.prefMapos.isSelected());
        Preferences.setPreference("grammalecte-Mc", panel.prefMc.isSelected());
        Preferences.setPreference("grammalecte-Nbsp", panel.prefNbsp.isSelected());
        Preferences.setPreference("grammalecte-Neg", panel.prefNeg.isSelected());
        Preferences.setPreference("grammalecte-Nf", panel.prefNf.isSelected());
        Preferences.setPreference("grammalecte-Num", panel.prefNum.isSelected());
        Preferences.setPreference("grammalecte-Ocr", panel.prefOcr.isSelected());
        Preferences.setPreference("grammalecte-Pleo", panel.prefPleo.isSelected());
        Preferences.setPreference("grammalecte-Poncfin", panel.prefPoncfin.isSelected());
        Preferences.setPreference("grammalecte-Ppas", panel.prefPpas.isSelected());
        Preferences.setPreference("grammalecte-Redon1", panel.prefRedon1.isSelected());
        Preferences.setPreference("grammalecte-Redon2", panel.prefRedon2.isSelected());
        Preferences.setPreference("grammalecte-Sgpl", panel.prefSgpl.isSelected());
        Preferences.setPreference("grammalecte-Tab", panel.prefTab.isSelected());
        Preferences.setPreference("grammalecte-Tu", panel.prefTu.isSelected());
        Preferences.setPreference("grammalecte-Typo", panel.prefTypo.isSelected());
        Preferences.setPreference("grammalecte-Unit", panel.prefUnit.isSelected());
        Preferences.setPreference("grammalecte-Virg", panel.prefVirg.isSelected());
        Preferences.setPreference("grammalecte-Vmode", panel.prefVmode.isSelected());
    }

    @Override
    public void restoreDefaults() {
        panel.fieldUrl.setText(GrammalectePlugin.DEFAULT_URL);
        panel.prefApos.setSelected(true);
        panel.prefBs.setSelected(true);
        panel.prefChim.setSelected(false);
        panel.prefConf.setSelected(true);
        panel.prefConj.setSelected(true);
        panel.prefDate.setSelected(true);
        panel.prefEepi.setSelected(true);
        panel.prefEsp.setSelected(true);
        panel.prefGn.setSelected(true);
        panel.prefImp.setSelected(true);
        panel.prefInfi.setSelected(true);
        panel.prefInte.setSelected(true);
        panel.prefLiga.setSelected(false);
        panel.prefMaj.setSelected(true);
        panel.prefMapos.setSelected(false);
        panel.prefMc.setSelected(true);
        panel.prefNbsp.setSelected(true);
        panel.prefNeg.setSelected(false);
        panel.prefNf.setSelected(true);
        panel.prefNum.setSelected(true);
        panel.prefOcr.setSelected(false);
        panel.prefPleo.setSelected(true);
        panel.prefPoncfin.setSelected(false);
        panel.prefPpas.setSelected(true);
        panel.prefRedon1.setSelected(false);
        panel.prefRedon2.setSelected(false);
        panel.prefSgpl.setSelected(true);
        panel.prefTab.setSelected(false);
        panel.prefTu.setSelected(true);
        panel.prefTypo.setSelected(true);
        panel.prefUnit.setSelected(true);
        panel.prefVirg.setSelected(true);
        panel.prefVmode.setSelected(true);
    }

    @Override
    protected void initFromPrefs() {
        panel.fieldUrl
                .setText(Preferences.getPreferenceDefault("grammalecte-serverUrl", GrammalectePlugin.DEFAULT_URL));
        panel.prefApos.setSelected(Preferences.isPreference("grammalecte-Apos"));
        panel.prefBs.setSelected(Preferences.isPreference("grammalecte-Bs"));
        panel.prefChim.setSelected(Preferences.isPreference("grammalecte-Chim"));
        panel.prefConf.setSelected(Preferences.isPreference("grammalecte-Conf"));
        panel.prefConj.setSelected(Preferences.isPreference("grammalecte-Conj"));
        panel.prefDate.setSelected(Preferences.isPreference("grammalecte-Date"));
        panel.prefEepi.setSelected(Preferences.isPreference("grammalecte-Eepi"));
        panel.prefEsp.setSelected(Preferences.isPreference("grammalecte-Esp"));
        panel.prefGn.setSelected(Preferences.isPreference("grammalecte-Gn"));
        panel.prefImp.setSelected(Preferences.isPreference("grammalecte-Imp"));
        panel.prefInfi.setSelected(Preferences.isPreference("grammalecte-Infi"));
        panel.prefInte.setSelected(Preferences.isPreference("grammalecte-Inte"));
        panel.prefLiga.setSelected(Preferences.isPreference("grammalecte-Liga"));
        panel.prefMaj.setSelected(Preferences.isPreference("grammalecte-Maj"));
        panel.prefMapos.setSelected(Preferences.isPreference("grammalecte-Mapos"));
        panel.prefMc.setSelected(Preferences.isPreference("grammalecte-Mc"));
        panel.prefNbsp.setSelected(Preferences.isPreference("grammalecte-Nbsp"));
        panel.prefNeg.setSelected(Preferences.isPreference("grammalecte-Neg"));
        panel.prefNf.setSelected(Preferences.isPreference("grammalecte-Nf"));
        panel.prefNum.setSelected(Preferences.isPreference("grammalecte-Num"));
        panel.prefOcr.setSelected(Preferences.isPreference("grammalecte-Ocr"));
        panel.prefPleo.setSelected(Preferences.isPreference("grammalecte-Pleo"));
        panel.prefPoncfin.setSelected(Preferences.isPreference("grammalecte-Poncfin"));
        panel.prefPpas.setSelected(Preferences.isPreference("grammalecte-Ppas"));
        panel.prefRedon1.setSelected(Preferences.isPreference("grammalecte-Redon1"));
        panel.prefRedon2.setSelected(Preferences.isPreference("grammalecte-Redon2"));
        panel.prefSgpl.setSelected(Preferences.isPreference("grammalecte-Sgpl"));
        panel.prefTab.setSelected(Preferences.isPreference("grammalecte-Tab"));
        panel.prefTu.setSelected(Preferences.isPreference("grammalecte-Tu"));
        panel.prefTypo.setSelected(Preferences.isPreference("grammalecte-Typo"));
        panel.prefUnit.setSelected(Preferences.isPreference("grammalecte-Unit"));
        panel.prefVirg.setSelected(Preferences.isPreference("grammalecte-Virg"));
        panel.prefVmode.setSelected(Preferences.isPreference("grammalecte-Vmode"));
    }
}
