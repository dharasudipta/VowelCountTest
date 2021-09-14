package org.vc.parser;

import org.apache.log4j.Logger;
import org.vc.enums.Vowels;
import org.vc.keyvalue.VowelMapKey;
import org.vc.keyvalue.VowelMapValue;

import java.util.*;

public class VowelParser {
    private final Logger log = Logger.getLogger(VowelParser.class);
    private String input;

    public VowelParser(String input) {
        this.input = input;
    }

    public String parse() throws IllegalStateException {
        if (input == null || "".equals(input) || " ".equals(input)) {
            throw new IllegalStateException("Input cannot be empty");
        }
        String[] words = input.split(" ");
//        int count = 0;
        words = trimWords(words);
        Arrays.stream(words).forEach(w -> log.info("words[] --> " + w));
        StringBuilder keyBuilder = null;
        Map<VowelMapKey, VowelMapValue> vowelCountMap = new HashMap<VowelMapKey, VowelMapValue>();
        VowelMapKey vowelMapKey = null;
        VowelMapValue vowelMapValue = null;
        for (String word : words) {
//            keyBuilder = new StringBuilder("(");
//            Set<String> vowelsSetFromWords = getVowelsSetFromWords(word);
//            keyBuilder.append(vowelsSetFromWords)
//                    .append(", ")
//                    .append(word.length())
//                    .append(")");
//            String key = keyBuilder.toString();
//            log.info(key);
//            if (vowelCountMap.containsKey(key)) {
//
//            } else {
//                vowelCountMap.put(key, (double) vowelsSetFromWords.size());
//            }
//            keyBuilder = null;
//            key = null;
            Set<String> vowelsSetFromWords = getVowelsSetFromWords(word);
            int totalVowelCount = getTotalVowelCountInWord(word);
            int length = word.length();
            vowelMapKey = new VowelMapKey(vowelsSetFromWords.toString(), length);
            vowelMapValue = new VowelMapValue(1, totalVowelCount);
            if (vowelCountMap.containsKey(vowelMapKey)) {
                VowelMapValue value = vowelCountMap.get(vowelMapKey);
                value.addWords(totalVowelCount);
            } else {
                vowelCountMap.put(vowelMapKey, vowelMapValue);
            }
        }
        StringBuilder formattedOutPut = new StringBuilder("");
        vowelCountMap.forEach((k, v) -> {
            formattedOutPut.append("\n")
                    .append(k)
                    .append(" --> ")
                    .append(v.getAverage());

        });
        log.info(formattedOutPut);
        return formattedOutPut.toString();
    }

    private int getTotalVowelCountInWord(String word) {
        char[] chars = word.toUpperCase().toCharArray();
        int counter = 0;
        for (char c : chars) {
            if (Vowels.isItVowel(String.valueOf(c))) {
                counter++;
            }
        }
        return counter;
    }

    private String[] trimWords(String[] words) {
        List<String> newTrimmedWords = new ArrayList<String>();
        for (String word : words) {//trimming words - removing punctuations or special characters.
            String trimmedWord = word.replaceAll("[^A-Za-z0-9]", "");
            if (!trimmedWord.isEmpty()) {
                newTrimmedWords.add(trimmedWord);
            }
        }
        String[] newTrimmedWordArray = new String[newTrimmedWords.size()];
        newTrimmedWordArray = newTrimmedWords.toArray(newTrimmedWordArray);
        return newTrimmedWordArray;
    }

    private Set<String> getVowelsSetFromWords(String word) {
        char[] chars = word.toCharArray();
        Set<String> vowelsSet = new TreeSet<String>();
        for (char c : chars) {
            String character = String.valueOf(c);
            if (Vowels.isItVowel(character)) {
                vowelsSet.add(character);
            }
        }
        return vowelsSet;
    }


}
