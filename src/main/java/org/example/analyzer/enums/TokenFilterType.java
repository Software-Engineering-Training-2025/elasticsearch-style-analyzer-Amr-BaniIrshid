package org.example.analyzer.enums;

import org.example.analyzer.filters.token.*;


public enum TokenFilterType {
    LOWERCASE(new LowercaseFilter()),
    ASCII_FOLD(new AsciiFoldFilter()),
    STOP_EN(new StopwordFilter()),
    PORTER_LITE(new PorterLiteFilter()),
    EDGE_NGRAM_1_3(new EdgeNgramFilter());

    private final TokenFilter filter;

    TokenFilterType(TokenFilter filter) {
        this.filter = filter;
    }

    public TokenFilter getFilter() {
        return filter;
    }
}