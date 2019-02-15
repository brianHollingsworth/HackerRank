/**
 * Write the following methods that return a lambda expression performing a
 * specified action:
 * 1.) PerformOperation isOdd(): The lambda expression must return true if a
 *     number is odd or false if it is even.
 * 2.) PerformOperation isPrime(): The lambda expression must return true if a
 *     number is prime or if it is composite.
 * 3.) PerformOperation isPalindrome(): The lambda expression must return true
 *     if a number is a palindrome or if it is not.
 *
 * Input Format: Input is handled for you by the locked stub code in your
 *               editor.
 *
 * Output Format: The locked stub code in your editor will print T lines of
 *                output.
 */
 
import java.io.*;
import java.util.*;

interface PerformOperation {
  boolean check(int a);
}

class MyMath {
  public boolean checker(PerformOperation p, int num) {
    return p.check(num);
  }

  public PerformOperation isOdd() {
    return (n) -> {
      return (n % 2 == 1);
    };
  }

  public PerformOperation isPrime() {
    return (n) -> {
      for (int i = 2; 2 * i < n; i++) {
        if (n % i == 0) {
          return false;
        }
      }
      return true;
    };
  }

  public PerformOperation isPalindrome() {
    return (n) -> {
      int remainder, sum = 0, temp;
      temp = n;
      while (n > 0) {
        remainder = n % 10;
        sum = (sum * 10) + remainder;
        n = n / 10;
      }

      if (temp == sum) {
        return true;
      } else {
        return false;
      }
    };
  }
}

   // Write your code here

public class JavaLambdaExpressions {
  public static void main(String[] args) throws IOException {
    MyMath ob = new MyMath();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    PerformOperation op;
    boolean ret = false;
    String ans = null;
    while (T--> 0) {
      String s = br.readLine().trim();
      StringTokenizer st = new StringTokenizer(s);
      int ch = Integer.parseInt(st.nextToken());
      int num = Integer.parseInt(st.nextToken());
      if (ch == 1) {
        op = ob.isOdd();
        ret = ob.checker(op, num);
        ans = (ret) ? "ODD" : "EVEN";
      } else if (ch == 2) {
        op = ob.isPrime();
        ret = ob.checker(op, num);
        ans = (ret) ? "PRIME" : "COMPOSITE";
      } else if (ch == 3) {
        op = ob.isPalindrome();
        ret = ob.checker(op, num);
        ans = (ret) ? "PALINDROME" : "NOT PALINDROME";
      }
      System.out.println(ans);
    }
  }
}
