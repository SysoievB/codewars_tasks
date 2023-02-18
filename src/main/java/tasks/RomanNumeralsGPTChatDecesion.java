package tasks;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumeralsGPTChatDecesion {
    public static void main(String[] args) {
        System.out.println(toRoman(3999));
    }

    private static final Map<Integer, String> romanNumeralMap = new LinkedHashMap<>();

    static {
        romanNumeralMap.put(1000, "M");
        romanNumeralMap.put(900, "CM");
        romanNumeralMap.put(500, "D");
        romanNumeralMap.put(400, "CD");
        romanNumeralMap.put(100, "C");
        romanNumeralMap.put(90, "XC");
        romanNumeralMap.put(50, "L");
        romanNumeralMap.put(40, "XL");
        romanNumeralMap.put(10, "X");
        romanNumeralMap.put(9, "IX");
        romanNumeralMap.put(5, "V");
        romanNumeralMap.put(4, "IV");
        romanNumeralMap.put(1, "I");
    }

    public static String toRoman(int number) {
        if (number < 1 || number > 3999) {
            throw new IllegalArgumentException("Number out of range (1 - 3999)");
        }
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, String> entry : romanNumeralMap.entrySet()) {
            int value = entry.getKey();
            String numeral = entry.getValue();
            while (number >= value) {
                result.append(numeral);
                number -= value;
            }
        }
        return result.toString();
    }

    public static int fromRoman(String romanNumeral) {
        if (romanNumeral == null || romanNumeral.length() == 0) {
            throw new IllegalArgumentException("Invalid Roman numeral");
        }
        int result = 0;
        int previousValue = 0;
        for (int i = romanNumeral.length() - 1; i >= 0; i--) {
            int finalI = i;
            int currentValue = romanNumeralMap.entrySet()
                    .stream()
                    .filter(entry -> entry.getValue().equals(String.valueOf(romanNumeral.charAt(finalI))))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Invalid Roman numeral"))
                    .getKey();
            if (currentValue < previousValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
            previousValue = currentValue;
        }
        return result;
    }
}
