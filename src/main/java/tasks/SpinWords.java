package tasks;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Write a function that takes in a string of one or more words, and returns the same string, but
 * with all five or more letter words reversed (Just like the name of this Kata). Strings passed
 * in will consist of only letters and spaces. Spaces will be included only when more than one word
 * is present.
 * <p>
 * spinWords( "Hey fellow warriors" ) => returns "Hey wollef sroirraw"
 * spinWords( "This is a test") => returns "This is a test"
 * spinWords( "This is another test" )=> returns "This is rehtona test"
 */
public class SpinWords {
    public static void main(String[] args) {
        System.out.println(new SpinWords().spinWords("Hey fellow warriors"));
    }

    public String spinWords(String sentence) {
        var words = Arrays
                .stream(sentence.split(" "))
                .collect(Collectors.toList());
        StringBuilder builder = new StringBuilder();
        for (String word : words) {
            if (word.length() >= 5) {
                builder.append(new StringBuilder(word).reverse().append(" "));
            } else {
                builder.append(word).append(" ");
            }
        }
        return builder.toString().stripTrailing();
    }
}
