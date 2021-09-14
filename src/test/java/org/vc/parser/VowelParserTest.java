package org.vc.parser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VowelParserTest {
    VowelParser vowelParser = null;

    @Before
    public void setUp() throws Exception {
//        String input = "Platon made bamboo boats.";
//        vowelParser = new VowelParser(input);
    }

    @Test
    public void testVowelParser_InputNull() {
        VowelParser vowelParser = new VowelParser(null);
        Exception exception = Assert.assertThrows(IllegalStateException.class, () -> {
            vowelParser.parse();
        });

        Assert.assertTrue("Input cannot be empty".contains(exception.getMessage()));
    }

    @Test
    public void testVowelParser_InputEmpty() {
        VowelParser vowelParser = new VowelParser(" ");
        Exception exception = Assert.assertThrows(IllegalStateException.class, () -> {
            vowelParser.parse();
        });

        Assert.assertTrue("Input cannot be empty".contains(exception.getMessage()));
    }

    @Test
    public void testVowelParser_InputSingleWord() {
        VowelParser vowelParser = new VowelParser("bamboo");
        Assert.assertEquals("\n({a, o}, 6) --> 3.0", vowelParser.parse());
    }

    @Test
    public void testVowelParser_InputValidSentenceWithPunctuation() {
        VowelParser vowelParser = new VowelParser("Platon made bamboo boats.");
        Assert.assertEquals("\n({a, o}, 6) --> 2.5\n" +
                "({a, o}, 5) --> 2.0\n" +
                "({a, e}, 4) --> 2.0", vowelParser.parse());
    }

    @Test
    public void testVowelParser_InputValidSentenceWithoutPunctuation() {
        VowelParser vowelParser = new VowelParser("Platon made bamboo boats");
        Assert.assertEquals("\n({a, o}, 6) --> 2.5\n" +
                "({a, o}, 5) --> 2.0\n" +
                "({a, e}, 4) --> 2.0", vowelParser.parse());
    }

    @Test
    public void testVowelParser_InputValidSentenceWithSpecialCharacter() {
        VowelParser vowelParser = new VowelParser("Platon made bamboo boats&");
        Assert.assertEquals("\n({a, o}, 6) --> 2.5\n" +
                "({a, o}, 5) --> 2.0\n" +
                "({a, e}, 4) --> 2.0", vowelParser.parse());
    }

    @Test
    public void testVowelParser_InputValidSentenceWithSpecialCharacterWord() {
        VowelParser vowelParser = new VowelParser("Platon made bamboo boats &@#$%*!&.");
        Assert.assertEquals("\n({a, o}, 6) --> 2.5\n" +
                "({a, o}, 5) --> 2.0\n" +
                "({a, e}, 4) --> 2.0", vowelParser.parse());
    }
}
