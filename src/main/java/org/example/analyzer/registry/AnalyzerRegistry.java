package org.example.analyzer.registry;

import org.example.analyzer.core.Analyzer;
import org.example.analyzer.core.AnalyzerBuilder;
import org.example.analyzer.enums.CharFilterType;
import org.example.analyzer.enums.TokenFilterType;
import org.example.analyzer.enums.TokenizerType;

import java.util.Map;

public class AnalyzerRegistry {
    private static final Map<String, Analyzer> registry = Map.of(
            "standard", AnalyzerBuilder.create()
                    .addCharFilter(CharFilterType.HTML_STRIP)
                    .addCharFilter(CharFilterType.NORMALIZE_DASHES)
                    .tokenizer(TokenizerType.STANDARD)
                    .addTokenFilter(TokenFilterType.LOWERCASE)
                    .addTokenFilter(TokenFilterType.ASCII_FOLD)
                    .build(),

            "english", AnalyzerBuilder.create()
                    .addCharFilter(CharFilterType.HTML_STRIP)
                    .addCharFilter(CharFilterType.MAPPING_SMART_QUOTES)
                    .addCharFilter(CharFilterType.NORMALIZE_DASHES)
                    .tokenizer(TokenizerType.STANDARD)
                    .addTokenFilter(TokenFilterType.LOWERCASE)
                    .addTokenFilter(TokenFilterType.ASCII_FOLD)
                    .addTokenFilter(TokenFilterType.STOP_EN)
                    .addTokenFilter(TokenFilterType.PORTER_LITE)
                    .build()
    );

    public static Analyzer get(String name) {
        Analyzer analyzer = registry.get(name);
        if (analyzer == null) {
            throw new IllegalArgumentException("Analyzer not found: " + name);
        }
        return analyzer;
    }
}