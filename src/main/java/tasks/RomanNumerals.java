package tasks;

import java.util.HashMap;
import java.util.Map;

/**
 * Create a RomanNumerals class that can convert a roman numeral to and from an integer value.
 * It should follow the API demonstrated in the examples below. Multiple roman numeral values will
 * be tested for each helper method.
 * <p>
 * Modern Roman numerals are written by expressing each digit separately starting with the left most
 * digit and skipping any digit with a value of zero. In Roman numerals 1990 is rendered: 1000=M, 900=CM, 90=XC; resulting in MCMXC.
 * 2008 is written as 2000=MM, 8=VIII; or MMVIII. 1666 uses each Roman symbol in descending order: MDCLXVI.
 * <p>
 * Input range : 1 <= n < 4000
 * <p>
 * In this kata 4 should be represented as IV, NOT as IIII (the "watchmaker's four").
 * <p>
 * Examples
 * RomanNumerals.toRoman(1000) // should return 'M'
 * RomanNumerals.fromRoman("M") // should return 1000
 * Help
 * Symbol	Value
 * I	1
 * IV	4
 * V	5
 * X	10
 * L	50
 * C	100
 * D	500
 * M	1000
 */
public class RomanNumerals {
    public static void main(String[] args) {
        //System.out.println(toRoman(2));
        System.out.println(toRoman(9));
    }

    public static String toRoman(int n) {
        if (n < 1 || n >= 4000) return "Wrong number";
        int numberForSubtraction = n;

        StringBuilder result = new StringBuilder();
        Map<Integer, StringBuilder> map = new HashMap<>(
                Map.of(
                        1, new StringBuilder("I"),
                        4, new StringBuilder("IV"),
                        5, new StringBuilder("V"),
                        9, new StringBuilder("IX"),
                        10, new StringBuilder("X"),
                        50, new StringBuilder("L"),
                        100, new StringBuilder("C"),
                        500, new StringBuilder("D"),
                        1000, new StringBuilder("M")
                ));

        var valuePresent = map.entrySet()
                .stream()
                .anyMatch(entry -> entry.getKey() == n);

        if (valuePresent) {
            result.append(map.get(n));
        }

        if (!valuePresent && n < 4) {
            for (int i = 0; i < n; i++) {
                result.append(map.get(1));
            }
        }

        if (!valuePresent && n < 10 && n > 5) {
            result.append(map.get(5));
            numberForSubtraction -= 5;
            if (numberForSubtraction < 4) {
                for (int i = 0; i < numberForSubtraction; i++) {
                    result.append(map.get(1));
                }
            }
        }

        //if(!valuePresent && n >10 && )

        return result.toString();
    }

    public static int fromRoman(String romanNumeral) {
        return 1;
    }
}
