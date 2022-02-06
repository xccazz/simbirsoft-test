package ru.galyuk.test;

import ru.galyuk.test.loader.HtmlLoader;
import ru.galyuk.test.processor.HtmlProcessor;
import java.io.*;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String encoding = System.getProperty("console.encoding", "utf-8");
        Scanner sc = new Scanner(System.in, encoding);
        PrintStream ps = new PrintStream(System.out, Boolean.parseBoolean(encoding));

        HtmlLoader htmlLoader = new HtmlLoader();
        String htmlStr = htmlLoader.loadHtml(args[0]);

        HtmlProcessor htmlProcessor = new HtmlProcessor();
        Map<String, Integer> htmlProc = htmlProcessor.processHtml(htmlStr);
        System.out.println(prepareResult(htmlProc));

    }

    private static String prepareResult(Map<String, Integer> statistic) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : statistic.entrySet()) {
            sb.append(entry.getKey()).append(" - ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }
}
