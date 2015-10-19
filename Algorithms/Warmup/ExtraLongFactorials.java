/**
 * ExtraLongFactorials.java
 *
 * - In this problem, I am given an integer N, and I must print the factorial of N.
 *
 * - Input: A single integer N.
 * - Output: The factorial of N.
 *
 * Example:
 * Input -> 25
 * Output -> 15511210043330985984000000
 */

import java.io.*;
import java.util.*;
import java.math.*;

public class ExtraLongFactorials {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      BigInteger n = sc.nextBigInteger();
      BigInteger factorial = BigInteger.ONE;

      while (!n.equals(BigInteger.ZERO)) {
         factorial = factorial.multiply(n);
         n = n.subtract(BigInteger.ONE);
      }

      System.out.println(factorial);
   }
}