package tasks;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Consider a sequence u where u is defined as follows:
 * <p>
 * The number u(0) = 1 is the first one in u.
 * For each x in u, then y = 2 * x + 1 and z = 3 * x + 1 must be in u too.
 * There are no other numbers in u.
 * Ex: u = [1, 3, 4, 7, 9, 10, 13, 15, 19, 21, 22, 27, ...]
 * <p>
 * 1 gives 3 and 4, then 3 gives 7 and 10, 4 gives 9 and 13, then 7 gives 15 and 22 and so on...
 * <p>
 * Task:
 * Given parameter n the function dbl_linear (or dblLinear...) returns the element u(n) of the
 * ordered (with <) sequence u (so, there are no duplicates).
 * <p>
 * Example:
 * dbl_linear(10) should return 22
 * <p>
 * Note:
 * Focus attention on efficiency
 */
public class DoubleLinear {
    public static void main(String[] args) {
        System.out.println(DoubleLinear.dblLinear(20));
    }

    public static int dblLinear(int n) {
        List<Integer> list = new ArrayList<>(List.of(1));

        for (int i = 0; i <= n; i++) {
            list.add(2 * list.get(i) + 1);
            list.add(3 * list.get(i) + 1);
        }
        /*int i = 0;
        while (i <= n) {
            list.add(2 * list.get(i) + 1);
            list.add(3 * list.get(i) + 1);
            i++;
        }*/

        return list.stream().distinct().sorted().collect(Collectors.toList()).get(n);
    }
}
