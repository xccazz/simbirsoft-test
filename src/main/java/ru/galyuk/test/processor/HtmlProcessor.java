package ru.galyuk.test.processor;

import logger.FileLogger;

import java.util.*;

public class HtmlProcessor {

    private static final List<Character> DELIMITER_LIST = Arrays.asList(' ', ',', '.', '!', '?', '"', ';', ':', '[', ']', '(', ')', '\n', '\r', '\t', '<', '/', '>', '}', '-', '_', '=', '{', '#', '&', '*', '{', '^', '$', '+', '—', '|', '\'', '\\');

    public Map<String, Integer> processHtml(String html) {
        FileLogger.log(">> Map<String, Integer> processHtml(String html)");
        Map<String, Integer> result = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < html.length(); i++) {
            char c = html.charAt(i);
            boolean contains = DELIMITER_LIST.contains(c);

            if (!contains) {
                sb.append(c);
            }

            if (contains || i == html.length() - 1) {
                String word = sb.toString();
                if (result.containsKey(word)) {
                    result.put(word, result.get(word) + 1);
                } else if (!word.isEmpty()) {
                    result.put(word, 1);
                }
                sb = new StringBuilder();
            }
        }
        FileLogger.log("<< Map<String, Integer> processHtml(String html)");
        return result;
    }
}


