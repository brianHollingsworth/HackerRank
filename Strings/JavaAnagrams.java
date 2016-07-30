/**
 * JavaAnagrams.java
 *
 * - In this problem, given two strings, print "Anagrams" if they are anagrams,
 *   print "Not Anagrams" if they are not. The strings may consist at most 50
 *   English characters; the comparison should NOT be case sensitive.
 *
 * - Input: First line will consist a string containing english alphabets which
 *          has at most 1000 characters. 2nd line will consist an integer k.
 *
 * - Output: In the first line print the lexicographically minimum substring. In
 *           the second line print the lexicographically maximum substring.
 */

 import java.io.*;
 import java.util.*;

 public class JavaAnagrams {

    static boolean isAnagram(String A, String B) {
       A = A.toLowerCase();
       char[] a = A.toCharArray();
       Arrays.sort(a);

       B = B.toLowerCase();
       char[] b = B.toCharArray();
       Arrays.sort(b);

       return Arrays.equals(a,b);
    }
     public static void main(String[] args) {

         Scanner sc=new Scanner(System.in);
         String A=sc.next();
         String B=sc.next();
         sc.close();
         boolean ret=isAnagram(A,B);
         if(ret)System.out.println("Anagrams");
         else System.out.println("Not Anagrams");

     }
 }
