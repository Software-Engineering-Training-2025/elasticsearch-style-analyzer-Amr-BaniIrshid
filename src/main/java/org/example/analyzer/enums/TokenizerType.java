package org.example.analyzer.enums;

import org.example.analyzer.core.Token;
import org.example.analyzer.tokenizer.StandardTokenizer;
import org.example.analyzer.tokenizer.Tokenizer;
import org.example.analyzer.tokenizer.WhitespaceTokenizer;

import java.util.List;

public enum TokenizerType implements Tokenizer {
    WHITESPACE(new WhitespaceTokenizer()),


    STANDARD(new StandardTokenizer());

    private final Tokenizer tokenizer;

    TokenizerType(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }

    @Override
    public List<Token> tokenize(String input) {
        return tokenizer.tokenize(input);
    }
}
