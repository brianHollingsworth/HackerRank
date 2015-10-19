/**
 * LibraryFine.java
 *
 * - In this problem, I am to make a program that calculates the fine for
 *   returning the book after the return date. I am given the actual and the
 *   expected return dates. The fine is calculated as follows:
 *   1.) If the book is returned on or before the expected return date, no fine
 *       will be charged. In other words, fine is 0.
 *   2.) If the book is returned in the same calendar month as the expected
 *       return date, the fine = 15 Hackos × Number of late days
 *   3.) If the book is not returned in the same calendar month but in the same
 *       calendar year as the expected return date, the fine = 500 Hackos × Number of late months
 *   4.) If the book is not returned in the same calendar year, the fine is
 *       fixed at 10,000 Hackos.
 *
 * - Input: I am given the actual and the expected return dates in D M Y format,
 *          respectively. There are two lines of input. The first line contains
 *          the D M Y values for the actual return date, and the next line
 *          contains the D M Y values for the expected return date.
 * - Output: Output a single value equal to the fine.
 *
 * Example:
 * Input -> 9 6 2015
 *          6 6 2015
 * Output -> 45
 */

import java.io.*;
import java.util.*;

public class LibraryFine {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      String actualReturnDate = sc.nextLine();
      String actualArray[]    = actualReturnDate.split(" ");
      int actualDay   = Integer.parseInt(actualArray[0]);
      int actualMonth = Integer.parseInt(actualArray[1]);
      int actualYear  = Integer.parseInt(actualArray[2]);

      String expectedReturnDate = sc.nextLine();
      String expectedArray[]    = expectedReturnDate.split(" ");
      int expectedDay   = Integer.parseInt(expectedArray[0]);
      int expectedMonth = Integer.parseInt(expectedArray[1]);
      int expectedYear  = Integer.parseInt(expectedArray[2]);

      int fine = 0;

      // The book was returned (actualDay - expectedDay) day(s) late,
      // and the fine is 15 Hackos per day. Understandable.
      if (actualDay > expectedDay && actualMonth == expectedMonth && actualYear == expectedYear)
         fine = (actualDay - expectedDay) * 15;

      // The book was returned (actualMonth - expectedMonth) months(s) late,
      // and the fine is 500 Hackos per month. Ouch!
      if (actualMonth > expectedMonth && actualYear == expectedYear)
         fine = (actualMonth - expectedMonth) * 500;

      // The book was returned on a different calender year, and the fine is
      // a fixed 10,000 Hackos. I'd like to place a second mortgage on my home.
      if (actualYear > expectedYear)
         fine = 10000;

      System.out.println(fine);

   }
}
