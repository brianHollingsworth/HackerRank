/**
 * ConditionalStatements.cpp
 *
 * - In this problem, I am given a positive integer, n:
 *   - If 1 <= n <= 9, then print the English representation of it. That is,
 *     "one" for 1, "two" for 2, and so on.
 *   - Otherwise, print "Greater than 9".
 * - Input: Only one integer, n.
 * - Output: The output as described above.
 */

#include <iostream>
#include <cstdio>
using namespace std;

int main() {
   // Complete the code.
   int n;

   cin >> n;

   if (n == 1) {
      cout << "one\n";
   } else if (n == 2) {
      cout << "two\n";
   } else if (n == 3) {
      cout << "three\n";
   } else if (n == 4) {
      cout << "four\n";
   } else if (n == 5) {
      cout << "five\n";
   } else if (n == 6) {
      cout << "six\n";
   } else if (n == 7) {
      cout << "seven\n";
   } else if (n == 8) {
      cout << "eight\n";
   } else if (n == 9) {
      cout << "nine\n";
   } else {
      cout << "Greater than 9\n";
   }

   return 0;
}
