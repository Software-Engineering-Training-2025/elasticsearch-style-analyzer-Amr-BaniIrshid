package org.example.analyzer.filters.chars;

public class DashNormalizeFilter implements CharFilter {

    @Override
    public String apply(String text) {
        return text.replace("–", "-").replace("—", "-");
    }
}