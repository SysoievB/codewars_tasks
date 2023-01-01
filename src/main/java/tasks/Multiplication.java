package tasks;

import java.util.Arrays;

/**
 * Your task, is to create N×N multiplication table, of size provided in parameter.
 * <p>
 * For example, when given size is 3:
 * <p>
 * 1 2 3
 * 2 4 6
 * 3 6 9
 * For the given example, the return value should be:
 * <p>
 * [[1,2,3],[2,4,6],[3,6,9]]
 */
public class Multiplication {
    public static void main(String[] args) {

        var arr = multiplicationTable(5);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    public static int[][] multiplicationTable(int n) {
        int[][] multiplicationArray = new int[n][n];
        for (int row = 0; row < multiplicationArray.length; row++) {
            for (int column = 0; column < multiplicationArray[row].length; column++) {
                multiplicationArray[row][column] = (row + 1) * (column + 1);
            }
        }
        return multiplicationArray;
    }
}
