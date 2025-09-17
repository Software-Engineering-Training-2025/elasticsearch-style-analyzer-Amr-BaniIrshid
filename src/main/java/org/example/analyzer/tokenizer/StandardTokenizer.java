package org.example.analyzer.tokenizer;

import org.example.analyzer.core.Token;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StandardTokenizer implements Tokenizer {
    private static final Pattern WORD_PATTERN =
            Pattern.compile("\\p{L}[\\p{L}\\p{Mn}\\p{Nd}_']*");

    @Override
    public List<Token> tokenize(String text) {
        Matcher m = WORD_PATTERN.matcher(text);
        List<Token> tokens = new ArrayList<>();
        while (m.find()) {
            tokens.add(new Token(m.group()));
        }
        return tokens;
    }
}