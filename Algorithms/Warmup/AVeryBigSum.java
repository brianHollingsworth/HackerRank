/**
 * AVeryBigSum.java
 *
 * - In this problem, I am given an array of integers of size 'n'. I need to
 *   print the sum of the elements in the array.
 * - The range of the 32-bit integer is (−2^31) to (2^31 - 1) or [−2147483648,2147483647].
 * - Input: The first line of input consists of an integer 'n'. The next line
 *          contains 'n' space-separated integers contained inside the array.
 * - Output: A single value equal to the sum of the elements in the array.
 */

import java.io.*;
import java.util.*;

public class AVeryBigSum {

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      int n = sc.nextInt();
      long total = 0;
      long[] sumArray = new long[n];

      for (int i = 0; i < n; i++) {
         sumArray[i] = sc.nextLong();
      }

      for (long i : sumArray) {
         total += i;
      }

      System.out.println(total);
      sc.close();
   }
}