package org.vc.utils;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {
    /**
     * @param path
     * @return
     */
    private static Logger log = Logger.getLogger(FileManager.class);

    public static String loadInput(Path path) {
        String input = null;
        try {
            input = Files.readString(path);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        log.info("File content --> " + input);
        return input;
    }

    public static void writeOutput(Path outputFilePath, String output) {
        try {
            Files.writeString(outputFilePath, output);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
