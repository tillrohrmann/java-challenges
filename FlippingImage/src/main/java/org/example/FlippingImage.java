package org.example;

/**
 * Hello world!
 */
public class FlippingImage {
    public static int[][] flipAndInvertImage(int[][] A) {
        final int rowLength = A[0].length;
        final int[][] result = new int[A.length][rowLength];

        for (int row = 0; row < A.length; row++) {
            for (int col = 0; col < rowLength / 2; col++) {
                if (A[row][col] == A[row][rowLength - col - 1]) {
                    result[row][col] = result[row][rowLength - col - 1] = 1 - A[row][col];
                } else {
                    result[row][col] = A[row][col];
                    result[row][rowLength - col - 1] = A[row][rowLength - col - 1];
                }
            }

            if (rowLength % 2 == 1) {
                result[row][rowLength / 2] = 1 - A[row][rowLength / 2];
            }
        }

        return result;
    }
}
