package tasks;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * You are going to be given a word. Your job is to return the middle character of the word.
 * If the word's length is odd, return the middle character. If the word's length is even,
 * return the middle 2 characters.
 * <p>
 * #Examples:
 * <p>
 * Kata.getMiddle("test") should return "es"
 * <p>
 * Kata.getMiddle("testing") should return "t"
 * <p>
 * Kata.getMiddle("middle") should return "dd"
 * <p>
 * Kata.getMiddle("A") should return "A"
 * #Input
 * <p>
 * A word (string) of length 0 < str < 1000 (In javascript you may get slightly more than 1000
 * in some test cases due to an error in the test cases). You do not need to test for this.
 * This is only here to tell you that you do not need to worry about your solution timing out.
 * <p>
 * #Output
 * <p>
 * The middle character(s) of the word represented as a string.
 */
public class MiddlePartOfWord {
    public static void main(String[] args) {
        System.out.println(getMiddle("1"));
    }

    public static String getMiddle(String word) {
        var list = Arrays.stream(word.split(""))
                .collect(Collectors.toList());
        StringBuilder stringBuilder = new StringBuilder();
        int middleVal = list.size() / 2;
        if (list.size() % 2 == 0) {
            stringBuilder.append(list.get(middleVal - 1));
            stringBuilder.append(list.get(middleVal));
        } else {
            stringBuilder.append(list.get(middleVal));
        }

        return stringBuilder.toString();
    }
}
