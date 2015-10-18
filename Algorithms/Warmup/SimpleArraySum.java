/**
 * SimpleArraySum.java
 *
 * - In this problem, I am given an array of integers of size 'n'. I need to
 *   print the sum of the elements in the array.
 * - Input: The first line of input consists of an integer 'n'. The next line
 *          contains 'n' space-separated integers contained inside the array.
 * - Output: A single value equal to the sum of the elements in the array.
 */

import java.io.*;
import java.util.*;

public class SimpleArraySum {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      int n = sc.nextInt();
      int total = 0;
      int[] sumArray = new int[n];

      for (int i = 0; i < n; i++) {
         sumArray[i] = sc.nextInt();
      }

      for (int i : sumArray) {
         total += i;
      }

      System.out.println(total);
      sc.close();
   }
}