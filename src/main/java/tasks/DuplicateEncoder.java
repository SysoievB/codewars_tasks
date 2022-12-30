package tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The goal of this exercise is to convert a string to a new string where each character in the new
 * string is "(" if that character appears only once in the original string, or ")" if that character
 * appears more than once in the original string. Ignore capitalization when determining if a character
 * is a duplicate.
 * <p>
 * Examples
 * "din"      =>  "((("
 * "recede"   =>  "()()()"
 * "Success"  =>  ")())())"
 * "(( @"     =>  "))(("
 * Notes
 * Assertion messages may be unclear about what they display in some languages. If you read "...It
 * Should encode XXX", the "XXX" is the expected result, not the input!
 */
public class DuplicateEncoder {
    public static void main(String[] args) {
        System.out.println(encode("did"));
    }

    static String encode(String word) {
        var list = Arrays.stream(word.split(""))
                .collect(Collectors.toList());

        var listDistinct = list.stream().distinct().collect(Collectors.toList());
        if (list.size() == listDistinct.size()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 1; i <= list.size(); i++) {
                stringBuilder.append("(");
            }
            return stringBuilder.toString();
        }
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i).equalsIgnoreCase(list.get(i + 1))) {
                resultList.add(")");
            } else {
                resultList.add("(");
            }
        }

        return String.join("", resultList);
    }
}
