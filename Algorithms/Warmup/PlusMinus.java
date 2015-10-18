/**
 * PlusMinus.java
 *
 * - In this problem, I am given an array containing integer values. I need to
 *   print the fraction of count of positive numbers, negative numbers and
 *   zeroes to the total numbers. Print the value of the fractions correct to
 *   three decimal places.
 * - Input: First line contains N, which is the size of the array. 
 *          Next line contains N integers A1,A2,A3,⋯,AN, separated by space.
 * - Output: Output three values on different lines equal to the fraction of
 *           count of positive numbers, negative numbers and zeroes to the total
 *           numbers respectively correct to three decimal places.
 */

import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;

public class PlusMinus {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      int n = sc.nextInt();
      while (n < 1 || n > 100) {
         System.out.println("Sorry, the number of integers must be >= 1 or <= 100.");
         n = sc.nextInt();
      }

      float[] array = new float[n];
      float positives = 0, negatives = 0, zeroes = 0;

      for (int i = 0; i < n; i++) {
         array[i] = sc.nextInt();

         if (array[i] > 0) {
            positives++;
         }
         else if (array[i] < 0) {
            negatives++;
         }
         else {
            zeroes++;
         }
      }

      double posPercent = Math.floor((positives/n) * 1000) / 1000, 
             negPercent = Math.floor((negatives/n) * 1000) / 1000,
             zeroPercent = Math.floor((zeroes/n) * 1000) / 1000;

      System.out.println(String.format("%.3f\n%.3f\n%.3f", posPercent, negPercent, zeroPercent));
    }
}