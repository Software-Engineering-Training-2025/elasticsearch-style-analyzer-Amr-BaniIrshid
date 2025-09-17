package org.example.analyzer.core;

import java.util.List;

public interface Analyzer {
    List<Token> analyze(String text);
}
