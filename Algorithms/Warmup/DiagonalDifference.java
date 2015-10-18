/**
 * DiagonalDifference.java
 *
 * - In this problem, I am given a square matrix of size N×N. I must calculate
 *   the absolute difference of the sums across the two main diagonals.
 * - Input: The first line contains a single integer N. The next N lines contain
 *          the rows of N integers describing the matrix.
 * - Output: Output a single integer equal to the absolute difference in the
 *           sums across the diagonals.
 */


import java.io.*;
import java.util.*;
import java.math.*;

public class DiagonalDifference {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      int n = sc.nextInt();

      while (n < 1 || n > 100) {
         System.out.println("Sorry, the number of rows must be >= 1 or <= 100.");
         n = sc.nextInt();
      }

      int[][] matrix = new int[n][n];
      int firstDiagonal = 0, secondDiagonal = 0;

      for (int row = 0; row < n; row++) {
         for (int column = 0; column < n; column++) {

            /**
             * Sample input:
             * 3
             * 11 2 4
             * 4 5 6
             * 10 8 -12
             */
            matrix[row][column] = sc.nextInt();

            /**
             * The first diagonal of the matrix is:
             * 11
             *    5
             *      -12
             * Sum across first diagonal: 11 + 5 - 12 = 4
             */
            if (row == column) {
               firstDiagonal += matrix[row][column];
            }

            /**
             * The second diagonal of the matrix is:
             *      4
             *    5
             * 10
             * Sum across second diagonal: 4 + 5 + 10 = 19
             */
            if (column == (n-1) - row) {
               secondDiagonal += matrix[row][column];
            }
         }
      }

      // Difference: |4 - 19| = 15
      System.out.println(Math.abs(firstDiagonal - secondDiagonal));
   }
}