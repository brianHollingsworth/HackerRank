/**
 * Project Euler #3: Largest Prime Factor
 * The prime factors of 13195 are 5, 7, 13, and 29.
 * What is the largest prime factor of a given number N?
 *
 * Input Format: First line contains T, the number of test cases. This is
 *               followed by T lines each containing an integer N.
 *
 * Output Format: For each test case, display the largest prime factor of N.
 */
#include <cmath>
#include <iostream>

using namespace std;

int main() {
  int t;
  cin >> t;
  for (int i = 0; i < t; i++) {
    long n;
    cin >> n;

    // If "n" is a large even number, we will divide by 2 multiple times
    // before incrementing with "j".
    while (n % 2 == 0) {
      n /= 2;
    }

    // According to the Google C++ Style Guide, "the names of variables
    // (including function parameters) and data members are all lowercase,
    // with underscores between words." I used to do camelcase in college, but
    // now I'm working on following Google's conventions.
    long largest_prime_factor = 0;

    // I kept getting a timeout issue on one of HackerRank's test cases, so I
    // did some research on how to cut down on the number of iterations my code
    // would do on large instances of "n". That lead me to this great response
    // from Mathematics Stack Exchange: "If you reach a trial factor that's less
    // than the square root of the number you're dividing into, you know that
    // the larger number must be the last prime factor. So there cannot possibly
    // be more than a few million trial divisions to do."
    // Thus, instead of counting up until j == n like I did in my commented code
    // below, we can break out of the loop possibly millions of iterations early
    // by only going up until j > √n.
    for (long j = 3; j <= sqrt(n); j += 2) {

      while (n % j == 0) {
        if (n > 1) {
          n /= j;
          largest_prime_factor = j;
        }
      }
    }

    // This last check--if (n > 1)--took me numerous attempts to figure out.
    // After resolving the aforementioned timeout issue by implementing
    // "j <= sqrt(n)", one of the other test cases would fail with "wrong
    // answer". I then realized that test case was likely n = 1 or n = 2. Thus,
    // I needed to create a variable that would still be equal to 0 when n = 1
    // or n = 2.
    if (n > 1) {
      largest_prime_factor = n;
    }
    cout << largest_prime_factor << endl;
  }
  return 0;
}

// int main() {
//   int t;
//   cin >> t;
//   for (int i = 0; i < t; i++) {
//     long n;
//     cin >> n;
//
//     for (long j = 2; j <= n; j++) {
//       // If "n" is a large even number, we will divide by 2 multiple times
//       // before incrementing "j".
//       while (n % j == 0) {
//         // No need for storing a variable other than "n" when we can
//         // just use compound assignment.
//         n /= j;
//       }
//     }
//
//     cout << n << endl;
//   }
//   return 0;
// }
