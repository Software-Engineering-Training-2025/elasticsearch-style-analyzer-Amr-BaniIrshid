package org.example.analyzer.filters.chars;

public class HtmlStripFilter implements CharFilter {

    @Override
    public String apply(String text) {
        return text.replaceAll("<[^>]+>", "");
    }
}