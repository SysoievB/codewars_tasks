package tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The Fibonacci numbers are the numbers in the following integer sequence (Fn):
 * <p>
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, ...
 * <p>
 * such as
 * <p>
 * F(n) = F(n-1) + F(n-2) with F(0) = 0 and F(1) = 1.
 * <p>
 * Given a number, say prod (for product), we search two Fibonacci numbers F(n) and F(n+1) verifying
 * <p>
 * F(n) * F(n+1) = prod.
 * <p>
 * Your function productFib takes an integer (prod) and returns an array:
 * <p>
 * [F(n), F(n+1), true] or {F(n), F(n+1), 1} or (F(n), F(n+1), True)
 * depending on the language if F(n) * F(n+1) = prod.
 * <p>
 * If you don't find two consecutive F(n) verifying F(n) * F(n+1) = prodyou will return
 * <p>
 * [F(n), F(n+1), false] or {F(n), F(n+1), 0} or (F(n), F(n+1), False)
 * F(n) being the smallest one such as F(n) * F(n+1) > prod.
 * <p>
 * Some Examples of Return:
 * (depend on the language)
 * <p>
 * productFib(714) # should return (21, 34, true),
 * # since F(8) = 21, F(9) = 34 and 714 = 21 * 34
 * <p>
 * productFib(800) # should return (34, 55, false),
 * # since F(8) = 21, F(9) = 34, F(10) = 55 and 21 * 34 < 800 < 34 * 55
 * -----
 * productFib(714) # should return [21, 34, true],
 * productFib(800) # should return [34, 55, false],
 * -----
 * productFib(714) # should return {21, 34, 1},
 * productFib(800) # should return {34, 55, 0},
 * -----
 * productFib(714) # should return {21, 34, true},
 * productFib(800) # should return {34, 55, false},
 */
public class FibonacciPro {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productFib(800)));
        System.out.println(Arrays.toString(productFibBestSolution(800)));
    }

    public static long[] productFib(long prod) {
        List<Long> list = new ArrayList<>(Arrays.asList(0L, 1L));
        long value;
        for (int i = 0; i < list.size(); i++) {
            value = list.get(i) + list.get(i + 1);
            list.add(value);
            if (value >= prod / 2) break;
        }

        List<Long> result = new ArrayList<>(3);

        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i) * list.get(i + 1)) == prod) {
                result.add(list.get(i));
                result.add(list.get(i + 1));
                result.add(1L);
                break;
            } else if ((list.get(i) * list.get(i + 1)) > prod) {
                result.add(list.get(i));
                result.add(list.get(i + 1));
                result.add(0L);
                break;
            }
        }

        return result.stream().mapToLong(Long::longValue).toArray();
    }

    public static long[] productFibBestSolution(long prod) {
        long a = 0;
        long b = 1;
        while (prod > a * b) {
            long temp = b;
            b = b + a;
            a = temp;
        }
        return new long[] { a, b, a * b == prod ? 1 : 0 };
    }
}
