/**
 * Complete the function displayPathtoPrincess which takes in two parameters -
 * the integer N and the character array grid. The grid will be formatted
 * exactly as you see it in the input, so for the sample input the princess is
 * at grid[2][0]. The function shall output moves (LEFT, RIGHT, UP or DOWN) on
 * consecutive lines to rescue/reach the princess. The goal is to reach the
 * princess in as few moves as possible.
 *
 * Input: The first line contains an odd integer N (3 <= N < 100) denoting the
 *        size of the grid. This is followed by an NxN grid. Each cell is
 *        denoted by '-' (ascii value: 45). The bot position is denoted by 'm'
 *        and the princess position is denoted by 'p'.
 * Output: Print out the moves you will take to rescue the princess in one go.
 *         The moves must be separated by '\n', a newline. The valid moves are
 *         LEFT or RIGHT or UP or DOWN.
 */

import java.io.*;
import java.util.*;

public class BotSavesPrincess {
static void displayPathtoPrincess(int n, String [] grid) {

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

   // Find the difference in y-axis positioning between Peach and Mario.
   // If the difference is less than 0, Mario is below Peach; we need to go UP.
   // Otherwise, Mario is below Peach, and we need to go DOWN.
   int yDifference = peach[0] - mario[0];
   if (yDifference < 0) {
      while (yDifference < 0) {
         System.out.println("UP");
         yDifference++;
      }
   }
   else {
      while (yDifference > 0) {
         System.out.println("DOWN");
         yDifference--;
      }
   }

   // Find the difference in x-axis positioning between Peach and Mario.
   // If the difference is less than 0, Mario is to the right of Peach; we need
   // to go LEFT. Otherwise, Mario is to the left of Peach, and we need to go
   // RIGHT.
   int xDifference = peach[1] - mario[1];
   if (xDifference < 0) {
      while (xDifference < 0) {
         System.out.println("LEFT");
         xDifference++;
      }
   }
   else {
      while (xDifference > 0) {
         System.out.println("RIGHT");
         xDifference--;
      }
   }
}

public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m;
        m = in.nextInt();
        String grid[] = new String[m];
        for(int i = 0; i < m; i++) {
            grid[i] = in.next();
        }

    displayPathtoPrincess(m,grid);
    }
}
