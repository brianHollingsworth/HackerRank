/**
 * JavaDatatypes.java
 *
 * - In this problem, I am only concerned about integer datatypes used to hold
 *   integer values (byte, short, int, long)
 * - Given an integer number, this program will determine which of those four
 *   datatypes can be used to store that number. If there are multiple suitable
 *   datatypes, this program will list them all in the order above.
 * - Input: The first line will contain an integer t, which denotes the number
 *          of inputs that will follow. Each of the next t lines will contain an
 *          integer n. The number can be arbitrarily large or small.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class JavaDatatypes {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        
        boolean isByte  = false,
                isShort = false,
                isInt   = false,
                isLong  = false;

        int count = sc.nextInt();
        
        for (int i = 0; i < count; i++) {
           
           if (!sc.hasNextByte() && !sc.hasNextShort() && !sc.hasNextInt() && !sc.hasNextLong()) {
              System.out.println(sc.next() + " can't be fitted anywhere.");
           }
           else {

              // If < 2^7 [-128 - 127] (8-bit)
              if (sc.hasNextByte())
                 isByte = true;

              // If < 2^15 [-32768 - 32767] (16-bit)
              if (sc.hasNextShort())
                 isShort = true;

              // If < 2^31 [-2147483648 - 2147483647] (32-bit)
              if (sc.hasNextInt())
                 isInt = true;

              // If < 2^63 [-2^63 - 2^63 - 1] (64-bit)
              if (sc.hasNextLong())
                 isLong = true;

              System.out.println(sc.next() + " can be fitted in:");

              if (isByte)
                 System.out.println("* byte");

              if (isShort)
                 System.out.println("* short");

              if (isInt)
                 System.out.println("* int");

              if (isLong)
                 System.out.println("* long");
           }

           isByte  = isShort = isInt = isLong  = false;
        }

        sc.close();
    }
}