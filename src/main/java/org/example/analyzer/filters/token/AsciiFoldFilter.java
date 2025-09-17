package org.example.analyzer.filters.token;

import org.example.analyzer.core.Token;

import java.text.Normalizer;
import java.util.List;

public class AsciiFoldFilter implements TokenFilter {
    @Override
    public List<Token> apply(Token token) {
        String norm = Normalizer.normalize(token.getTerm(), Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");
        return List.of(new Token(norm));
    }
}