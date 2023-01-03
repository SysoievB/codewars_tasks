package tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Complete the solution so that it splits the string into pairs of two characters.
 * If the string contains an odd number of characters then it should replace the missing
 * second character of the final pair with an underscore ('_').
 * <p>
 * Examples:
 * <p>
 * * 'abc' =>  ['ab', 'c_']
 * * 'abcdef' => ['ab', 'cd', 'ef']
 */
public class StringSplit {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solutionOneLine("abcde")));
    }

    public static String[] solution(String s) {
        String str = "";
        if (s.length() % 2 != 0) {
            str = s.concat("_");
        } else {
            str = s;
        }

        return str.split("(?<=\\G.{2})");
    }

    public static String[] solutionOneLine(String s) {
        return s.length() % 2 != 0
                ? s.concat("_").split("(?<=\\G.{2})")
                : s.split("(?<=\\G.{2})");
    }
}
