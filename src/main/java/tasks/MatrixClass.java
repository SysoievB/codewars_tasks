package tasks;

import java.util.Arrays;

/**
 * Write a function that accepts a square matrix (N x N 2D array) and returns the determinant of the matrix.
 * <p>
 * How to take the determinant of a matrix -- it is simplest to start with the smallest cases:
 * <p>
 * A 1x1 matrix |a| has determinant a.
 * <p>
 * A 2x2 matrix [ [a, b], [c, d] ] or
 * <p>
 * |a  b|
 * |c  d|
 * has determinant: a*d - b*c.
 * <p>
 * The determinant of an n x n sized matrix is calculated by reducing the problem to the calculation of the determinants
 * of n matrices ofn-1 x n-1 size.
 * <p>
 * For the 3x3 case, [ [a, b, c], [d, e, f], [g, h, i] ] or
 * <p>
 * |a b c|
 * |d e f|
 * |g h i|
 * the determinant is: a * det(a_minor) - b * det(b_minor) + c * det(c_minor) where det(a_minor) refers to taking the
 * determinant of the 2x2 matrix created by crossing out the row and column in which the element a occurs:
 * <p>
 * |- - -|
 * |- e f|
 * |- h i|
 * Note the alternation of signs.
 * <p>
 * The determinant of larger matrices are calculated analogously, e.g. if M is a 4x4 matrix with first row [a, b, c, d], then:
 * <p>
 * det(M) = a * det(a_minor) - b * det(b_minor) + c * det(c_minor) - d * det(d_minor)
 */
public class MatrixClass {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2}, {3, 4}};
        Arrays.stream(matrix).forEach(v -> System.out.println(v.length));
        System.out.println("---------------------");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println(matrix[i][j]);
            }
            System.out.println();
        }

        System.out.println(determinant(new int[][]{{1, 2}, {3, 4}}));
    }

    public static int determinant(int[][] matrix) {
        int result = 0;
        if (matrix.length == 1) {
            result = Math.abs(matrix.length);
        } else if (matrix.length >= 2) {
            result = matrix[matrix.length - 2][matrix.length - 2] * matrix[matrix.length - 1][matrix.length - 1]
                    - matrix[matrix.length - 2][matrix.length - 1] * matrix[matrix.length - 1][matrix.length - 2];
        }

        return result;
    }
}
