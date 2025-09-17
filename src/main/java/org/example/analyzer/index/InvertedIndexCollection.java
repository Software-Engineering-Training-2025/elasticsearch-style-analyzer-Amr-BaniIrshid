package org.example.analyzer.index;

import org.example.analyzer.core.Analyzer;
import org.example.analyzer.core.Token;

import java.util.*;
import java.util.stream.Collectors;

public class InvertedIndexCollection {
    private final Analyzer analyzer;
    private final Map<String, Set<String>> index = new HashMap<>();

    public InvertedIndexCollection(Analyzer analyzer) {
        this.analyzer = analyzer;
    }

    public void addDocument(String docId, String text) {
        if (text == null || text.isBlank()) return;

        List<Token> tokens = analyzer.analyze(text);
        for (Token token : tokens) {
            index.computeIfAbsent(token.getTerm(), k -> new HashSet<>())
                    .add(docId);
        }
    }

    public List<String> search(String query) {
        if (query == null || query.isBlank()) return List.of();

        List<Token> queryTokens = analyzer.analyze(query);

        Map<String, Long> scores = queryTokens.stream()
                .map(Token::getTerm)
                .map(index::get)
                .filter(Objects::nonNull)
                .flatMap(Set::stream)
                .collect(Collectors.groupingBy(
                        docId -> docId,
                        Collectors.counting()
                ));

        return scores.entrySet().stream()
                .sorted(
                        Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder())
                                .thenComparing(Map.Entry.comparingByKey())
                )
                .map(Map.Entry::getKey)
                .toList();
    }
}