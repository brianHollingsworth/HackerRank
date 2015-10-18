/**
 * JavaEndOfFile.java
 *
 * - In this problem, I need to read a file until EOF and print the contents of
 *   the file to stdout. For each line, the line number will be printed followed
 *   by a single spance and the line content.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class JavaEndOfFile {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);

        int lineCount = 0;

        while (sc.hasNextLine()) {
           lineCount++;
           System.out.println(lineCount + " " + sc.nextLine());
        }
    }
}