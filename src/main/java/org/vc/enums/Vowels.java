package org.vc.enums;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public enum Vowels {
    A("A"),
    E("E"),
    I("I"),
    O("O"),
    U("U");

    private final String vowel;

    Vowels(String e) {
        this.vowel = e;
    }

    public static boolean isItVowel(String ch) {
        return Arrays.stream(Vowels.values()).anyMatch(p -> p.getVowel().equalsIgnoreCase(ch));
    }

    public String getVowel() {
        return vowel;
    }
}
