package org.example.analyzer.filters.token;

import org.example.analyzer.core.Token;
import org.tartarus.snowball.ext.EnglishStemmer;

import java.util.List;

public class PorterLiteFilter implements TokenFilter {

    @Override
    public List<Token> apply(Token token) {
        EnglishStemmer stemmer = new EnglishStemmer();
        stemmer.setCurrent(token.getTerm());
        stemmer.stem();
        return List.of(new Token(stemmer.getCurrent()));
    }
}