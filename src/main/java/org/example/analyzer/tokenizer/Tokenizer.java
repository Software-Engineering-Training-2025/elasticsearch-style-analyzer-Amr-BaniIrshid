package org.example.analyzer.tokenizer;

import org.example.analyzer.core.Token;

import java.util.List;

@FunctionalInterface
public interface Tokenizer {
    List<Token> tokenize(String input);
}
