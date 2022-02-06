package ru.galyuk.test.loader;

import ru.galyuk.test.logger.FileLogger;
import java.io.*;
import java.net.URL;

public class HtmlLoader {

    public String loadHtml(String url) {
        FileLogger.log(">>  loadHtml()");
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
            FileLogger.logError("во время получения HTML" , exception);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                FileLogger.logError("во время получения HTML", e);
            }
        }
        FileLogger.log("<< loadHtml()");
        return result.toString();
    }
}