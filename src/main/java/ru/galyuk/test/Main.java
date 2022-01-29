package ru.galyuk.test;

import ru.galyuk.test.loader.HtmlLoader;
import ru.galyuk.test.processor.HtmlProcessor;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.Map;

public class Main {

    private static final String TARGET_URL = "https://www.simbirsoft.com/";

    public static void main(String[] args) {
        HtmlLoader htmlLoader = new HtmlLoader();
        String htmlStr = htmlLoader.loadHtml(TARGET_URL);

        HtmlProcessor htmlProcessor = new HtmlProcessor();
        Map<String, Integer> htmlProc = htmlProcessor.processHtml(htmlStr);
        System.out.println(htmlProc);

    }
}
