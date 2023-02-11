package tasks;

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
        System.out.println(toRoman(2));
        System.out.println(toRomanTen(4 ));
        System.out.println(6%5);
    }

    public static String toRoman(int n) {
        if (n < 1 || n > 4000) return "Wrong number";

        String romanNumber = "";
        if (n == 1) romanNumber = "I";
        else if (n == 4) romanNumber = "IV";
        else if (n == 5) romanNumber = "V";
        else if (n == 10) romanNumber = "X";
        else if (n == 50) romanNumber = "L";
        else if (n == 100) romanNumber = "C";
        else if (n == 500) romanNumber = "D";
        else if (n == 1000) romanNumber = "M";
        return romanNumber;
    }

    public static String toRomanTen(int n) {
        StringBuilder romanNumber = new StringBuilder();
        if (n < 1 || n > 9) return "";

        int val;
        if (n > 5) {
            val = n % 5;
            romanNumber.append("V");
            if (val == 1) romanNumber.append("I");
            else if (val == 2) romanNumber.append("II");
            else if (val == 3) romanNumber.append("III");
            else if (val == 4) romanNumber.append("IV");
            //else if (val == 5) romanNumber.append("V");
        }

        return romanNumber.toString();
    }

    public static int fromRoman(String romanNumeral) {
        return 1;
    }
}
