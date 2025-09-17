package org.example.analyzer.core;

import org.example.analyzer.enums.CharFilterType;
import org.example.analyzer.enums.TokenFilterType;
import org.example.analyzer.enums.TokenizerType;

import java.util.ArrayList;
import java.util.List;

public class AnalyzerBuilder {
    private final List<CharFilterType> charFilters = new ArrayList<>();
    private TokenizerType tokenizer;
    private final List<TokenFilterType> tokenFilters = new ArrayList<>();

    private AnalyzerBuilder() {
    }

    public static AnalyzerBuilder create() {
        return new AnalyzerBuilder();
    }

    public AnalyzerBuilder addCharFilter(CharFilterType type) {
        this.charFilters.add(type);
        return this;
    }

    public AnalyzerBuilder tokenizer(TokenizerType type) {
        this.tokenizer = type;
        return this;
    }

    public AnalyzerBuilder addTokenFilter(TokenFilterType type) {
        this.tokenFilters.add(type);
        return this;
    }

    public Analyzer build() {
        if (tokenizer == null) {
            throw new IllegalStateException("Tokenizer must be set before building analyzer");
        }
        return new AnalyzerFacade(charFilters, tokenizer, tokenFilters);
    }
}
