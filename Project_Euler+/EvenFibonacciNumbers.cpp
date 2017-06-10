/**
 * Project Euler #2: Even Fibonacci Numbers
 * Each new term in the Fibonacci sequence is generated by adding the previous
 * two terms. By starting with 1 and 2, the first 10 terms will be: 1, 2, 3, 5,
 * 8, 13, 21, 34, 55, 89, ... By considering the terms in the Fibonacci sequence
 * whose values do not exceed N, find the sum of the even-valued terms.
 *
 * Input Format: First line contains T that denotes the number of test cases.
 *               This is followed by T lines, each containing an integer, N.
 *
 * Output Format: Print the required answer for each test case.
 */
#include <cstdio>
#include <cstdlib>
#include <iostream>

using namespace std;

int main() {
  int t;
  cin >> t;

  for (int i = 0; i < t; i++) {
    long n;
    cin >> n;

    long sum = 0;
    long previous = 1;
    long current = 2;
    long temp = 0;
    while (current < n) {
      if (current % 2 == 0) {
        sum += current;
      }
      temp = previous + current;
      previous = current;
      current = temp;
    }

    cout << sum << endl;
  }
  return 0;
}
