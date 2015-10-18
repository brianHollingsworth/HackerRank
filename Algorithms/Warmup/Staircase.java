/**
 * Staircase.java
 *
 * - In this problem, I am given the height of the staircase. I need to print a
 *   staircase as shown in the example.
 * - Input: You are given an integer N depicting the height of the staircase.
 * - Output: Draw a staircase of height N in the format given below.
 *
 * Example:
 * 6
 *
 *      #
 *     ##
 *    ###
 *   ####
 *  #####
 * ######
 */

import java.io.*;
import java.util.*;

public class Staircase {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      int height = sc.nextInt();
      while (height < 1 || height > 100) {
         System.out.println("Sorry, the height must be >= 1 or <= 100.");
         height = sc.nextInt();
      }

      for (int hashtags = 1; hashtags <= height; hashtags++) {
         for (int spaces = 1; spaces <= height - hashtags; spaces++) {
            System.out.print(" ");          
         }
         
         for (int i = 0; i < hashtags; i++) {
            System.out.print("#");
         }

         System.out.println();
      }
   }
}