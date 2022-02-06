package ru.galyuk.test.logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger {
    private static final String LOG_FILE_PATH = "simbirsoft.log";

    public static void logError(String message, Exception error) {
        FileLogger.log(String.format("Возникла ошибка %s: '%s'", message, error.getMessage()));
    }

    public static void log(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE_PATH, true))) {
            writer.write(message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}