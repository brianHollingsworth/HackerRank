/**
 * BotSavesPrincess2
 *
 * In this version of "Bot saves princess", Princess Peach and bot's position
 * are randomly set. Can you save the princess?
 * Complete the function nextMove which takes in 4 parameters - an integer N,
 * integers r and c indicating the row & column position of the bot and the
 * character array grid - and outputs the next move the bot makes to rescue the
 * princess.
 *
 * Output only the next move you take to rescue the princess. Valid moves are
 * LEFT, RIGHT, UP or DOWN
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BotSavesPrincess2 {
   static void nextMove(int n, int r, int c, String [] grid){

      // Since I'm forced to accept a String array as my parameter, I am going to
      // convert 'grid' into an ArrayList of character arrays for easier parsing.
      ArrayList<char[]> gridArrayList = new ArrayList<char[]>();
      for (String gridLine: grid) {
         gridArrayList.add(gridLine.toCharArray());
      }

      int[] mario = {0,0};
      int[] peach = {0,0};

      // Find Mario and Peach by iterating through the 2D ArrayList.
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
            if (gridArrayList.get(i)[j] == 'm') {
               mario[0] = i;
               mario[1] = j;
            }
            if (gridArrayList.get(i)[j] == 'p') {
               peach[0] = i;
               peach[1] = j;
            }
         }
      }

      // Find the difference in x-axis positioning between Peach and Mario.
      int xDifference = peach[1] - mario[1];

      // If Peach's y-axis positioning is greater than Mario's, she is to the
      // right of Mario, and Mario needs to move right.
      if (xDifference > 0) {
         System.out.println("RIGHT");
      }

      // Else, Peach is to the left of Mario, and Mario needs to move
      // left.
      else if (xDifference < 0) {
         System.out.println("LEFT");
      }

      // Else, Mario & Peach's x-axis respective positionings are equal. Thus,
      // Mario only needs to move left and right.
      else {
         // Find the difference in y-axis positioning between Peach and Mario.
         int yDifference = peach[0] - mario[0];

         // If Peach's y-axis positioning is greater than Mario's, she is below
         // Mario, and Mario needs to move down.
         if (yDifference > 0) {
            System.out.println("DOWN");
         }

         // Else, if Peach's y-axis positioning is less than Mario's, she is above
         // Mario, and Mario needs to move up.
         else if (yDifference < 0) {
            System.out.println("UP");
         }
      }
   }

   public static void main(String[] args) {
           Scanner in = new Scanner(System.in);
           int n,r,c;
           n = in.nextInt();
           r = in.nextInt();
           c = in.nextInt();
           in.useDelimiter("\n");
           String grid[] = new String[n];


           for(int i = 0; i < n; i++) {
               grid[i] = in.next();
           }

       nextMove(n,r,c,grid);

   }
}
