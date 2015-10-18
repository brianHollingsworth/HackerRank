/**
 * JavaLoops.java 
 *
 * In this problem, my knowledge of Java loops is tested.
 *  - Given three integers a, b, and n, output the following series:
 *    a + 2^0*b, a + 2^0*b + 2^1*b, ..., a + 2^0*b + 2^1*b ... + 2^n-1*b
 *
 *  - The first line will contain the numbers of integers, t. Each of the next t
 *    lines will have three integers: a, b, and n, respectively. 
 *
 *  - Contraints: 0 <= a,b <= 50
 *                1 <= n <= 15
 */


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class JavaLoops {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);

        /* Create a two-dimensional array to hold each of the user's lines. */
        int numberOfLines = sc.nextInt();
        int[][] userInput = new int[numberOfLines][3];

        int a, b, n, sum, var, total = 0;

        /* Get each line of input in the following order.
            a  b  n
           [1][2][3]
           [4][5][6]
        */
        for (int i = 0; i < numberOfLines; i++) {
           for (int j = 0; j < 3; j++) {
              userInput[i][j] = sc.nextInt();
           }
        }

        for (int m = 0; m < numberOfLines; m++) {
           a = userInput[m][0];
           b = userInput[m][1];
           n = userInput[m][2];
           total = a;

           if ((a >= 0 && b >= 0) && 
               (a <= 50 && b <= 50) && 
               (n >= 1 && n <= 15)) {

                 for (int j = 0; j < n; j++) {
                    var = (int)(Math.pow(2,j)) * b;
                    total = total + var;
                    System.out.print(total + " ");
                 }

                 System.out.println("");
                 total = 0;
           }
           else {
              System.out.println("Your numbers do not fit the constraints:\n" +
                                 "0 <= a, b <= 50, and 1 <= n <= 15");
           }
        }
    }
}