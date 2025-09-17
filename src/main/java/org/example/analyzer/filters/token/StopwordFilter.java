package org.example.analyzer.filters.token;

import org.example.analyzer.core.Token;

import java.util.List;
import java.util.Set;

public class StopwordFilter implements TokenFilter {
    private static final Set<String> STOPWORDS = Set.of(
            "the","and","of","to","in","a","an","is","it","for","on"
    );

    @Override
    public List<Token> apply(Token token) {
        if (STOPWORDS.contains(token.getTerm().toLowerCase())) {
            return List.of();
        }
        return List.of(token);
    }
}