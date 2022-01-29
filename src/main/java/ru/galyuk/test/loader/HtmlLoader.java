package ru.galyuk.test.loader;

import java.io.*;
import java.net.URL;

public class HtmlLoader {

    public String loadHtml(String url) {
        StringBuilder result = new StringBuilder();

        try {
            URL simbirsoftURL = new URL(url);

            InputStream inputStream = simbirsoftURL.openStream();

            Reader reader = new InputStreamReader(inputStream);

            BufferedReader br = new BufferedReader(reader);

            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                result.append(inputLine);
            }

            br.close();
        } catch (IOException exception) {
            System.out.println("Возникла ошибка, при загрузке HTML по: " + url);
            exception.printStackTrace();
        }
        return result.toString();

    }
}
