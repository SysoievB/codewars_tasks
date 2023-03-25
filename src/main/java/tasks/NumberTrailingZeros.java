package tasks;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Write a program that will calculate the number of trailing zeros in a factorial of a given number.
 * <p>
 * N! = 1 * 2 * 3 *  ... * N
 * <p>
 * Be careful 1000! has 2568 digits...
 * <p>
 * For more info, see: http://mathworld.wolfram.com/Factorial.html
 * <p>
 * Examples
 * zeros(6) = 1
 * # 6! = 1 * 2 * 3 * 4 * 5 * 6 = 720 --> 1 trailing zero
 * <p>
 * zeros(12) = 2
 * # 12! = 479001600 --> 2 trailing zeros
 * Hint: You're not meant to calculate the factorial. Find another way to find the number of zeros.
 */
public class NumberTrailingZeros {
    public static void main(String[] args) {
        System.out.println(zeros(0));
    }

    public static int zeros(int n) {
        if (n == 0) return 0;

        BigInteger factorialResult = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            factorialResult = factorialResult.multiply(BigInteger.valueOf(i));
        }
        int zeros = 0;
        List<Integer> zerosList = new ArrayList<>();
        String number = factorialResult.toString();
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == '0') {
                zeros++;
                zerosList.add(zeros);
            } else {
                zeros = 0;
            }
        }

        return Collections.max(zerosList);
    }
}
