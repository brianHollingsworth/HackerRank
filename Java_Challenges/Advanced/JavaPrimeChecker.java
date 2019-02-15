/**
 * You are given a class Solution and its main method in the editor. Your task
 * is to create a class Prime. The class Prime should contain a single method
 * checkPrime.
 *
 * Input Format: There are only five lines of input, each containing one
 *               integer.
 *
 * Output Format: There will be only four lines of output. Each line contains
 *                only prime numbers depending upon the parameters passed to
 *                checkPrime in the main method of the class Solution. In case
 *                there is no prime number, then a blank line should be printed.
 */

import java.io.*;
import java.util.*;
import java.lang.reflect.*;
import static java.lang.System.in;

class Prime {

  public Prime() { }

  public void checkPrime(int ... args) {
    for (int n : args) {
      boolean isPrime = true;
      for (int i = 2; 2 * i <= n; i++) {
        if (n % i == 0) {
          isPrime = false;
          break;
        }
      }
      // To pass HackerRank's test cases, we have to exclude 1 from being
      // printed.
      if (n > 1 && (isPrime)) {
        System.out.print(n + " ");
      }
      isPrime = true;
    }
    System.out.println("");
  }
}

public class JavaPrimeChecker {

  public static void main(String[] args) {
    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(in));
      int n1 = Integer.parseInt(br.readLine());
      int n2 = Integer.parseInt(br.readLine());
      int n3 = Integer.parseInt(br.readLine());
      int n4 = Integer.parseInt(br.readLine());
      int n5 = Integer.parseInt(br.readLine());
      Prime ob = new Prime();
      ob.checkPrime(n1);
      ob.checkPrime(n1,n2);
      ob.checkPrime(n1,n2,n3);
      ob.checkPrime(n1,n2,n3,n4,n5);
      Method[] methods = Prime.class.getDeclaredMethods();
      Set<String> set = new HashSet<>();
      boolean overload = false;

      for (int i = 0;i < methods.length; i++) {
        if (set.contains(methods[i].getName())) {
          overload=true;
          break;
        }
        set.add(methods[i].getName());
      }
      if (overload) {
        throw new Exception("Overloading not allowed");
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
