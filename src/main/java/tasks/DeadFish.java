package tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Write a simple parser that will parse and run Deadfish.
 * <p>
 * Deadfish has 4 commands, each 1 character long:
 * <p>
 * i increments the value (initially 0)
 * d decrements the value
 * s squares the value
 * o outputs the value into the return array
 * Invalid characters should be ignored.
 * <p>
 * Deadfish.parse("iiisdoso") =- new int[] {8, 64};
 */
public class DeadFish {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(DeadFish.parse("iiisdoso")));
    }

    public static int[] parse(String data) {
        List<Integer> result = new ArrayList<>();
        int value = 0;
        var arr = data.split("");
        for (int i = 0; i < arr.length; i++) {
            if (Objects.equals(arr[i], "i")) {
                ++value;
            } else if (Objects.equals(arr[i], "d")) {
                --value;
            } else if (Objects.equals(arr[i], "s")) {
                value *= value;
            } else if (Objects.equals(arr[i], "o")) {
                result.add(value);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
