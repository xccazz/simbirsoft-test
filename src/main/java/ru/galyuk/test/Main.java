package ru.galyuk.test;

import ru.galyuk.test.loader.HtmlLoader;
import ru.galyuk.test.processor.HtmlProcessor;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        HtmlLoader htmlLoader = new HtmlLoader();

        if (args.length < 1) {
            System.out.println("Не указан параметр URL! (смотреть 'readme.md')");
        }
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