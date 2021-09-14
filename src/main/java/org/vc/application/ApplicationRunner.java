package org.vc.application;

import org.apache.log4j.Logger;
import org.vc.parser.VowelParser;
import org.vc.utils.FileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ApplicationRunner {
    private static Logger log = Logger.getLogger(ApplicationRunner.class);

    public static void main(String args[]) {
        Path inputFilePath = Paths.get("src/main/resources/INPUT.txt");
        String input = FileManager.loadInput(inputFilePath);
        VowelParser vowelParser = new VowelParser(input);
        String output = null;
        try {
            output = vowelParser.parse();
        } catch (IllegalStateException e) {
            log.error(e.getMessage());
        }
        Path outputFilePath = Paths.get("src/main/resources/OUTPUT.txt");
        FileManager.writeOutput(outputFilePath, output);
    }
}
