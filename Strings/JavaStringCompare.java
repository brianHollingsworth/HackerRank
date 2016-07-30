/**
 * JavaStringCompare.java
 *
 * - In this problem, given a string, find out the lexicographically smallest
 *   and largest substring of length k.
 *
 * - Input: First line will consist a string containing english alphabets which
 *          has at most 1000 characters. 2nd line will consist an integer k.
 *
 * - Output: In the first line print the lexicographically minimum substring. In
 *           the second line print the lexicographically maximum substring.
 */

import java.io.*;
import java.util.*;

 public class JavaStringCompare {

     public static void main(String[] args) {
         Scanner sc    = new Scanner(System.in);
         String string = sc.next();
         int k         = sc.nextInt();

         String minSub = string.substring(0,k);
         String maxSub = string.substring(0,k);
         for (int i = 1; i <= string.length()-k; i++) {
            if (minSub.compareTo(string.substring(i,i+k)) > 0) {
               minSub = string.substring(i,i+k);
            }
            if (maxSub.compareTo(string.substring(i,i+k)) < 0) {
               maxSub = string.substring(i,i+k);
            }
         }

         System.out.println(minSub + "\n" + maxSub);
     }
 }
