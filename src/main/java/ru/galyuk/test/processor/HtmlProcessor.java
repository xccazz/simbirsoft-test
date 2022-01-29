package ru.galyuk.test.processor;

import java.util.*;

public class HtmlProcessor {

    private static final List<Character> DELIMITER_LIST = Arrays.asList(' ', ',', '.', '!', '?', '"', ';', ':', '[', ']', '(', ')', '\n', '\r', '\t', '<', '/', '>', '}', '-', '_', '=', '{', '#', '&', '*', '{', '^', '$', '+', '—', '|','\'', '\\');

    public Map<String, Integer> processHtml(String html) {
        Map<String, Integer> result = new HashMap<>(); // ключ значение
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < html.length(); i++) {
            char c = html.charAt(i);
            //privet,kak
            if (DELIMITER_LIST.contains(c)) {
                String word = sb.toString();
                if (result.containsKey(word)) {
                    result.put(word, result.get(word) + 1);
                } else {
                    result.put(word, 1);
                }
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }

        }
        return result;
    }

}


