package org.example.analyzer.filters.chars;

public class SmartQuotesFilter implements CharFilter {

    @Override
    public String apply(String text) {
        return text.replace("’", "'")
                .replace("“", "\"")
                .replace("”", "\"");
    }
}