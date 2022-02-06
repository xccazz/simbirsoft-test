package ru.galyuk.test.processor;

import org.junit.Assert;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class HtmlProcessorTest {

    @Test
    public void processHtmlTest() {
        HtmlProcessor htmlProcessor = new HtmlProcessor();
        Map<String, Integer> result = htmlProcessor.processHtml(getHtmlFromResource("htmlTest.html"));
        Assert.assertEquals(59, result.size());
        Assert.assertTrue(result.containsKey("Здесь"));
        Assert.assertEquals(Integer.valueOf(1), result.get("нет"));
        Assert.assertFalse(result.containsKey(""));
    }

    private String getHtmlFromResource(String path) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(path), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}


