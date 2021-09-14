package org.vc.keyvalue;

public class VowelMapValue {
    private int wordCount;
    private int vowelCount;

    public VowelMapValue(int wordCount, int vowelCount) {
        this.wordCount = wordCount;
        this.vowelCount = vowelCount;
    }

    public void addWords(int numberOfVowels) {
        wordCount++;
        vowelCount = vowelCount + numberOfVowels;
    }

    public Double getAverage() {
        return Double.valueOf(vowelCount) / wordCount;
    }

    @Override
    public String toString() {
        return "VowelMapValue{" +
                "wordCount=" + wordCount +
                ", vowelCount=" + vowelCount +
                ", Average=" + getAverage() +
                '}';
    }
}
