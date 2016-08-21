import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BotCleanLarge {
static void next_move(int posr, int posc, int dimh, int dimw, String[] board) {

   int currentRow = posr;
   int currentCol = posc;

   // Gather the total numeber of cells on the board. The distance to a dirty
   // cell should never exceed the total number of cells on the board.
   int numberOfSteps = dimh * dimw;
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
        int [] dim = new int[2];
        for(int i=0;i<2;i++) pos[i] = in.nextInt();
        for(int i=0;i<2;i++) dim[i] = in.nextInt();
        String board[] = new String[dim[0]];
        for(int i=0;i<dim[0];i++) board[i] = in.next();
        next_move(pos[0], pos[1], dim[0], dim[1], board);
    }
}
