package org.example.analyzer.filters.token;

import org.example.analyzer.core.Token;

import java.util.ArrayList;
import java.util.List;

public class EdgeNgramFilter implements TokenFilter {
    @Override
    public List<Token> apply(Token token) {
        String s = token.getTerm();
        List<Token> grams = new ArrayList<>();
        for (int len = 1; len <= 3 && len <= s.length(); len++) {
            grams.add(new Token(s.substring(0, len)));
        }
        return grams;
    }
}