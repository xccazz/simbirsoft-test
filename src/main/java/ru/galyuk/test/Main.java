package ru.galyuk.test;

import ru.galyuk.test.loader.HtmlLoader;
import ru.galyuk.test.processor.HtmlProcessor;
import sun.misc.IOUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.Map;

public class Main {

    // private static final String TARGET_URL = "https://www.simbirsoft.com/";

    public static void main(String[] args) {
        HtmlLoader htmlLoader = new HtmlLoader();
        String htmlStr = htmlLoader.loadHtml(args[0]);

        HtmlProcessor htmlProcessor = new HtmlProcessor();
        Map<String, Integer> htmlProc = htmlProcessor.processHtml(htmlStr);
     //   String.getBytes(your_string.getBytes('Cp866'),'Cp1251');

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
