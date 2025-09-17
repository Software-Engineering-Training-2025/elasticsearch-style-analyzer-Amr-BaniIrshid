package org.example;

import org.example.analyzer.core.Analyzer;
import org.example.analyzer.core.AnalyzerBuilder;
import org.example.analyzer.enums.TokenFilterType;
import org.example.analyzer.enums.TokenizerType;
import org.example.analyzer.index.InvertedIndexCollection;
import java.util.List;
import org.example.analyzer.enums.*;


public class Main {
    public static void main(String[] args) {
        Analyzer analyzer = AnalyzerBuilder.create()
                .addCharFilter(CharFilterType.HTML_STRIP)
                .addCharFilter(CharFilterType.NORMALIZE_DASHES)
                .addCharFilter(CharFilterType.MAPPING_SMART_QUOTES)
                .tokenizer(TokenizerType.STANDARD)
                .addTokenFilter(TokenFilterType.LOWERCASE)
                .addTokenFilter(TokenFilterType.ASCII_FOLD)
                .addTokenFilter(TokenFilterType.EDGE_NGRAM_1_3)
                .build();

        InvertedIndexCollection index = new InvertedIndexCollection(analyzer);

        index.addDocument("doc1", "<h1>Résumé—Examples</h1>");
        index.addDocument("doc2", "Running runners tested");
        index.addDocument("doc3", "JavaScript and Java are not the same");
        index.addDocument("doc4", "It’s a test café");
        index.addDocument("doc5", "java java world hello");
        index.addDocument("doc6", "java world world hello");
        index.addDocument("doc7", "hello hello world");
        index.addDocument("doc8", "java java java hello");
        index.addDocument("doc9", "world world world world");

        List<String> results1 = index.search("resume");
        System.out.println("Query: resume -> " + results1);

        List<String> results2 = index.search("run");
        System.out.println("Query: run -> " + results2);

        List<String> results3 = index.search("jav");
        System.out.println("Query: jav -> " + results3);

        List<String> results4 = index.search("cafe");
        System.out.println("Query: cafe -> " + results4);

        List<String> results5 = index.search("test");
        System.out.println("Query: test -> " + results5);

        List<String> results6 = index.search("java world hello");
        System.out.println("Query: java world hello -> " + results6);



    }
}
