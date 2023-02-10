package tasks;

/**
 * Create a function that takes a positive integer and returns the next bigger number that can be
 * formed by rearranging its digits. For example:
 * <p>
 * 12 ==> 21
 * 513 ==> 531
 * 2017 ==> 2071
 * nextBigger(num: 12)   // returns 21
 * nextBigger(num: 513)  // returns 531
 * nextBigger(num: 2017) // returns 2071
 * If the digits can't be rearranged to form a bigger number, return -1 (or nil in Swift):
 * <p>
 * 9 ==> -1
 * 111 ==> -1
 * 531 ==> -1
 * nextBigger(num: 9)   // returns nil
 * nextBigger(num: 111) // returns nil
 * nextBigger(num: 531) // returns nil
 */
public class BiggestNumber {
    public static void main(String[] args) {
        System.out.println(nextBiggerNumber(414));
    }

    public static long nextBiggerNumber(long n) {
        long lastValue = n % 10;
        long middleValue = (n % 100 - lastValue) / 10;
        long firstValue = (n - (n % 100 - lastValue) - lastValue);
        if (firstValue == 0L && middleValue == 0L) return -1;
        if (middleValue < lastValue) {
            return firstValue + lastValue * 10 + middleValue;
        }
        return -1L;
    }
}
