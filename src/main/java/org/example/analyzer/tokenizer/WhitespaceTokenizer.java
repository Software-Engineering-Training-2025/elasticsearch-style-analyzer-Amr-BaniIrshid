package org.example.analyzer.tokenizer;

import org.example.analyzer.core.Token;

import java.util.Arrays;
import java.util.List;

public class WhitespaceTokenizer implements Tokenizer {
    @Override
    public List<Token> tokenize(String text) {
        return Arrays.stream(text.split("\\s+"))
                .filter(s -> !s.isBlank())
                .map(Token::new)
                .toList();
    }
}