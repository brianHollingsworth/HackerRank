/**
 * ForLoop.cpp
 *
 * - In this problem, I will be given two positive integers, a and b (a <= b),
 *   separated by a newline. For each integer n from a to b:
 *   - If 1 <= n <=9. the print the English representation of it. That is, "one"
 *     for 1, "two" for 2, and so on.
 *   - If n > 9 and even, then print "even".
 *   - If n > 9 and odd, the print "odd".
 */

#include <iostream>
#include <cstdio>
using namespace std;

int main() {
   // Complete the code.
   int a, b;

   cin >> a >> b;

      for (int i = a; i <= b; i++) {
         if (i >= 1 && i <= 9) {
            if (i == 1) {
               cout << "one\n";
            } else if (i == 2) {
               cout << "two\n";
            } else if (i == 3) {
               cout << "three\n";
            } else if (i == 4) {
               cout << "four\n";
            } else if (i == 5) {
               cout << "five\n";
            } else if (i == 6) {
               cout << "six\n";
            } else if (i == 7) {
               cout << "seven\n";
            } else if (i == 8) {
               cout << "eight\n";
            } else {
               cout << "nine\n";
            }
         }
         else {
            if (i % 2 == 0) {
               cout << "even\n";
            }
            else {
               cout << "odd\n";
            }
         }
      }

   return 0;
}
