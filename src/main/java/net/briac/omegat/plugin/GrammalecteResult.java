package net.briac.omegat.plugin;

import java.util.List;

public class GrammalecteResult {
    public final String message;
    public final int start;
    public final int end;
    public final String ruleId;
    public final List<String> suggestions;

    public GrammalecteResult(String message, int start, int end, String ruleId, List<String> suggestions) {
        this.message = message;
        this.start = start;
        this.end = end;
        this.ruleId = ruleId;
        this.suggestions = suggestions;
    }
}
