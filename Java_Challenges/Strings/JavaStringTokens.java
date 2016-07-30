/**
 * JavaStringTokens.java
 *
 * - In this problem, given a string, s, matching the regular expression
 *   [A-Za-z !,?._'@]+, split the string into tokens. We define a token to be
 *   one or more consecutive English alphabetic letters. Then, print the number
 *   of tokens, followed by each token on a new line.
 *
 * - Input: A single string, s.
 *
 * - Output: On the first line, print an integer, n, denoting the number of
 *   tokens in string s (they do not need to be unique). Next, print each of the
 *   n tokens on a new line in the same order as they appear in input string s.
 */

import java.io.*;
import java.util.*;

public class JavaStringTokens {

   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      String s = scan.nextLine();
      scan.close();

      int n = 0;
      String[] tokens = s.split("[!,?.\\_'@]+");
      System.out.println(tokens.length);

      for (String token: tokens) {
         System.out.println(token);
      }
   }
}
