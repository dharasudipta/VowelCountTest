package org.vc.keyvalue;

import java.util.Objects;

public class VowelMapKey {
    private String vowelSet;
    private int wordLength;

    public VowelMapKey(String vowelSet, int wordLength) {
        this.vowelSet = vowelSet;
        this.wordLength = wordLength;
    }

    @Override
    public boolean equals(Object other) {
//        if (this == other) return true;
//        if (other == null || getClass() != other.getClass()) return false;
//        VowelMapKey that = (VowelMapKey) other;
//        return wordLength == that.wordLength && Objects.equals(vowelSet, that.vowelSet);
        if (!(other instanceof VowelMapKey)) {
            return false;
        }

        VowelMapKey key = (VowelMapKey) other;
        if (!this.vowelSet.equalsIgnoreCase(key.vowelSet)) {
            return false;
        }

        if (this.wordLength != key.wordLength) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vowelSet, wordLength);
    }

    public String getVowelSet() {
        return vowelSet;
    }

    public void setVowelSet(String vowelSet) {
        this.vowelSet = vowelSet;
    }

    public int getWordLength() {
        return wordLength;
    }

    public void setWordLength(int wordLength) {
        this.wordLength = wordLength;
    }

    @Override
    public String toString() {
        StringBuilder toStringBuilder = new StringBuilder("(");
        toStringBuilder.append(vowelSet.replace('[', '{').replace(']', '}'))
                .append(", ")
                .append(wordLength)
                .append(")");
        return toStringBuilder.toString();
    }
}
