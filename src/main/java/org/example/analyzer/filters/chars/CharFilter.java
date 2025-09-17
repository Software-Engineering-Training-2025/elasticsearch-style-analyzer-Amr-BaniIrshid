package org.example.analyzer.filters.chars;

@FunctionalInterface
public interface CharFilter {
    String apply(String input);
}
