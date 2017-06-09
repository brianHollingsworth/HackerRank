/**
 * Project Euler #1: Multiples of 3 and 5
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we
 * get 3, 5, 6, and 9. The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below N.
 *
 * Input Format: First line contains T that denotes the number of test cases.
 *               This is followed by lines, each containing an integer, N.
 *
 * Output Format: For each test case, print an integer that denotes the sum of
 *                all the multiples of 3 or 5 below N.
 */
#include <cstdio>
#include <cstdlib>
#include <iostream>

using namespace std;

// https://math.stackexchange.com/questions/9259/find-the-sum-of-all-the-multiples-of-3-or-5-below-1000
// The code I wrote that's commented at the bottom kept getting timeout issues
// with two of HackerRank's test cases, so I needed to try a different method. I
// discovered that the modulo operator is computationally expensive, so I ended
// up finding a helpful Math Stack Exchange link (above) that doesn't involve
// any use of the modulo operator.
long long Euler001(long long n) { return n * (n + 1) / 2; }

int main() {
  int t;
  cin >> t;

  for (int i = 0; i < t; i++) {
    long long n;
    cin >> n;
    // To avoid double counting values that are multiples of both 3 and 5, we
    // must apply XOR.
    cout << Euler001((n - 1) / 3) * 3 + Euler001((n - 1) / 5) * 5 -
                Euler001((n - 1) / 15) * 15
         << endl;
  }

  return 0;
}

// int main() {
//   long long t;
//   cin >> t;
//   for (int a0 = 0; a0 < t; a0++) {
//     long long n;
//     cin >> n;
//
//     long long sumOfAllMultiples = 0;
//     for (long long i = 0; i < 28; i++) {
//       if (i % 3 == 0 || i % 5 == 0) {
//         sumOfAllMultiples += i;
//         for (long long j = 0; j < n; i += 30) {
//           if (n + sumOfAllMultiples < i) {
//             sumOfAllMultiples += (n + sumOfAllMultiples);
//           }
//         }
//       }
//     }
//
//     cout << sumOfAllMultiples << endl;
//   }
//   return 0;
// }
