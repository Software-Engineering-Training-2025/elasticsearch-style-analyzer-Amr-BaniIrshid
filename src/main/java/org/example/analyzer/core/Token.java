package org.example.analyzer.core;

public class Token {
    public final String term;

    public Token(String term) {
        this.term = term;
    }

    public String getTerm() {
        return term;
    }

    @Override
    public String toString() {
        return term;
    }
}
