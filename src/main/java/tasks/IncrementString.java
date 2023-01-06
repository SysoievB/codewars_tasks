package tasks;

/**
 * Your job is to write a function which increments a string, to create a new string.
 * <p>
 * If the string already ends with a number, the number should be incremented by 1.
 * If the string does not end with a number. the number 1 should be appended to the new string.
 * Examples:
 * <p>
 * foo -> foo1
 * <p>
 * foobar23 -> foobar24
 * <p>
 * foo0042 -> foo0043
 * <p>
 * foo9 -> foo10
 * <p>
 * foo099 -> foo100
 * <p>
 * Attention: If the number has leading zeros the amount of digits should be considered.
 */
public class IncrementString {
    public static void main(String[] args) {
        System.out.println(incrementString("foo9"));
        //System.out.println("foo9".replaceAll("\\D+", ""));
    }

    public static String incrementString(String str) {
        int number;
        if (str.matches("\\d+")) {
            number = Integer.parseInt(str.replaceAll("\\d+", ""));
            number = number + 1;
        } else {
            number = 1;
        }

        return str.replaceAll("[^a-z]", "") + number;
    }
}
