package org.example.analyzer.core;


import org.example.analyzer.enums.CharFilterType;
import org.example.analyzer.enums.TokenizerType;
import org.example.analyzer.enums.TokenFilterType;

import java.util.ArrayList;
import java.util.List;

public class AnalyzerFacade implements Analyzer {
    private final List<CharFilterType> charFilters;
    private final TokenizerType tokenizer;
    private final List<TokenFilterType> tokenFilters;

    public AnalyzerFacade(List<CharFilterType> charFilters,
                          TokenizerType tokenizer,
                          List<TokenFilterType> tokenFilters) {
        this.charFilters = new ArrayList<>(charFilters);
        this.tokenizer = tokenizer;
        this.tokenFilters = new ArrayList<>(tokenFilters);
    }

    @Override
    public List<Token> analyze(String text) {
        if (text == null) return List.of();

        for (CharFilterType charFilterType : charFilters) {
            text = charFilterType.getFilter().apply(text);
        }

        List<Token> tokens = tokenizer.tokenize(text);

        for (TokenFilterType tokenFilterType : tokenFilters) {
            tokens = tokens.stream()
                    .flatMap(token -> tokenFilterType.getFilter().apply(token).stream())
                    .toList();
        }

        return tokens;
    }
}