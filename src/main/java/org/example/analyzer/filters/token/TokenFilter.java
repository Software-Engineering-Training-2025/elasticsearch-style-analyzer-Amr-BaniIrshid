package org.example.analyzer.filters.token;

import org.example.analyzer.core.Token;

import java.util.List;

@FunctionalInterface
public interface TokenFilter {
    List<Token> apply(Token token);
}
