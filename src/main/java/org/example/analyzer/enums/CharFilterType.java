package org.example.analyzer.enums;

import org.example.analyzer.filters.chars.CharFilter;
import org.example.analyzer.filters.chars.DashNormalizeFilter;
import org.example.analyzer.filters.chars.HtmlStripFilter;
import org.example.analyzer.filters.chars.SmartQuotesFilter;


public enum CharFilterType {
    HTML_STRIP(new HtmlStripFilter()),
    NORMALIZE_DASHES(new DashNormalizeFilter()),
    MAPPING_SMART_QUOTES(new SmartQuotesFilter());

    private final CharFilter filter;

    CharFilterType(CharFilter filter) {
        this.filter = filter;
    }

    public CharFilter getFilter() {
        return filter;
    }
}