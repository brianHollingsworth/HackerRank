/**
 * BotCleanStochastic
 *
 * The game Bot Clean took place in a deterministic environment. In this
 * version, the bot is given 200 moves to clean as many dirty cells as possible.
 * The grid initially has 1 dirty cell. When the bot cleans this cell, a new
 * cell in the grid is made dirty. The new cell can be anywhere in the grid.
 *
 * The bot here is positioned at the top left corner of a 5*5 grid. Your task is
 * to move the bot to appropriate dirty cell and clean it.
 *
 * Input: The first line contains two space separated integers which indicate
 *        the current position of the bot. The board is indexed using Matrix
 *        Convention. 5 lines follow representing the grid. Each cell in the
 *        grid is represented by any of the following 3 characters: 'b' (ascii
 *        value 98) indicates the bot's current position, 'd' (ascii value 100)
 *        indicates a dirty cell and '-' (ascii value 45) indicates a clean cell
 *        in the grid.
 *        Note: If the bot is on a dirty cell, the cell will still have 'd' on
 *        it.
 *
 * Output: The action that is taken by the bot in the current step, and it can
 *         be either one of the movements in 4 directions or cleaning up the
 *         cell in which it is currently located. The valid output strings are
 *         LEFT, RIGHT, UP and DOWN or CLEAN. If the bot ever reaches a dirty
 *         cell, output CLEAN to clean the dirty cell. Repeat this process until
 *         all the cells on the grid are cleaned.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BotCleanStochastic {

   static void next_move(int posr, int posc, String[] board) {

      int currentRow = posr;
      int currentCol = posc;

      // Gather the total numeber of cells on the board. The distance to a dirty
      // cell should never exceed the total number of cells on the board.
      int numberOfSteps = board.length * board.length;
      int[] dirtyCell = new int[2];
      boolean onCleanCell = false;

      for (int i = 0; i < board.length; i++) {
         for (int j = 0; j < board[i].length(); j++) {
             if (board[i].charAt(j) == 'd') {
                  int distanceToDirtyCell = Math.abs(currentRow - i) + Math.abs(currentCol- j);
                  if (numberOfSteps > distanceToDirtyCell) {
                     dirtyCell[0] = i;
                     dirtyCell[1] = j;
                     numberOfSteps = distanceToDirtyCell;
                  }
             }
         }
      }

      // If the row on which the bot is currently located has a greater y-axis
      // value that the dirty cell's, the bot is below the dirty cell. Thus,
      // move up and make note
      if (currentRow > dirtyCell[0]) {
         System.out.println("UP");
         onCleanCell = true;
      }

      // If the row on which the bot is currently located has a smaller y-axis
      // value than the dirty cell's, the bot is above the dirty cell. Thus,
      // move down.
      else if (currentRow < dirtyCell[0]) {
         System.out.println("DOWN");
         onCleanCell = true;
      }

      // Otherwise, the bot is on the same y-axis as the dirty cell. Thus, we
      // need to move either left or right.
      if (!onCleanCell) {
         if (currentCol > dirtyCell[1]) {
            System.out.println("LEFT");
            onCleanCell = true;
         }
         else if (currentCol < dirtyCell[1]) {
            System.out.println("RIGHT");
            onCleanCell = true;
         }
      }

      // If neither the y-axis nor the x-axis differ from the closest dirty
      // cell's, the bot must be on top of the dirty cell. Thus, clean.
      if (!onCleanCell) {
         System.out.println("CLEAN");
      }
   }

   public static void main(String[] args) {
     Scanner in = new Scanner(System.in);
     int [] pos = new int[2];
     String board[] = new String[5];
     for(int i=0;i<2;i++) pos[i] = in.nextInt();
     for(int i=0;i<5;i++) board[i] = in.next();
     next_move(pos[0], pos[1], board);
   }
}
