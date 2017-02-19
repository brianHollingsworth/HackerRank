# We are trying to hack together a smart programming IDE. Help us build a
# feature which auto-detects the programming language, given the source code.
# There are only three languages which we are interested in "auto-detecting":
# Java, C and Python.
# We will provide links to a few short or medium size programs for Java, C and
# Python. In case you aren't familiar with some of these languages, these
# samples will help you make observations about the lexical structure and syntax
# of these programming languages. These sample programs are only for your manual
# inspection. You cannot read or access these sample-programs from the code you
# submit.
#
# After this, you will be provided with tests, where you are provided the source
# code for programs - or partial code snippets, but you do not know which
# language they are in. For each test, try to detect which language the source
# code is in.
#
# Input Format: Source code of a program, or a code snippet, which might be in
#               C, Java or Python.
#
# Output Format: One line containing the name of the Programming language which
#                you have detected: This might be either C or Java or Python.
#
# Sample Input:
#
# import java.io.*;
#
# public class SquareNum {
#
#    public static void main(String args[]) throws IOException
#    {
#       System.out.println("This is a small Java Program!");
#    }
# }
#
# Sample Output:
#
# Java

#!/usr/bin/perl

while (<>) {
   chomp;

   # In C, user and system header files are included using the preprocessing
   # directive ‘#include’.
   if (/\#include\<.+>/) {
      print "C";
      last;
   }

   # In Java, user and system header files are included using the preprocessing
   # directive ‘import’. If we
   elsif (/import java.+;/) {
      print "Java";
      last;
   }

   # Looking through the example Python code, each sample program contained one
   # or both ways to perform the print function: printing a variable or printing
   # a string. Let's consider finding a line containing "print", followed by
   # either an alphanumeric variable or a string with any kind of content.
   elsif (/print [A-Za-z0-9]|".+"/) {
      print "Python";
      last;
   }
}
