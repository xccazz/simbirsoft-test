package ru.galyuk.test.loader;

import logger.FileLogger;
import java.io.*;
import java.net.URL;

public class HtmlLoader {

    public String loadHtml(String url) {
        FileLogger.log(">> String loadHtml(String url)");
        StringBuilder result = new StringBuilder();
        BufferedReader br = null;

        try {
            URL simbirsoftURL = new URL(url);
            InputStream inputStream = simbirsoftURL.openStream();
            br = new BufferedReader(new InputStreamReader(inputStream));
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                result.append(inputLine);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
            FileLogger.logError("в String loadHtml(String url)" , exception);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                FileLogger.logError("в String loadHtml(String url)", e);
            }
        }
        FileLogger.log("<< String loadHtml(String url)");
        return result.toString();
    }
}