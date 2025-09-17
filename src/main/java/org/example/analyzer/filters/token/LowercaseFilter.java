package org.example.analyzer.filters.token;

import org.example.analyzer.core.Token;

import java.util.List;

public class LowercaseFilter implements TokenFilter {
    @Override
    public List<Token> apply(Token token) {
        return List.of(new Token(token.getTerm().toLowerCase()));
    }


}