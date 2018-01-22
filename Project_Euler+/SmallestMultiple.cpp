/**
 * Project Euler #5: Smallest Multiple
 * 2520 is the smallest number that can be divided by each of the numbers from 1
 * to 10 without any remainder. What is the smallest positive number that is
 * evenly divisible (divisible with no remainder) by all of the numbers from 1
 * to N?
 *
 * Input Format: First line contains T that denotes the number of test cases.
 *               This is followed by T lines, each containing an integer, N.
 *
 * Output Format: Print the required answer for each test case in a new line.
 */

#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

// A quick helper function for solving log(n), base 'b'.
int logarithm(int b, int n) {
    return (int)(log(n)/log(b)); 
}

// I remember learning about the Sieve of Eratosthenes in Distrete Mathematics.
// This method is far more efficient and modular than hard-coding and iterating
// through 'n' primes.
void SieveOfEratosthenes(int n, vector<int> &primes);

int main() {
  int t;
  cin >> t;
  long long smallestMultiple;
  
  vector<int> primes;
  SieveOfEratosthenes(51, primes);

  for (int i = 0; i < t; i++) {
    int n;
    cin >> n;
    smallestMultiple = 1;

    for (vector<int>::iterator it = primes.begin(); it != primes.end(); it++) {

      // For one of the test cases, n is set to 1, and it causes the code to
      // fail. Thus, I needed to create this special case.
      if (n < *it) {
        break;
      }

      smallestMultiple *= pow(*it,logarithm(*it,n));
    }

    cout << smallestMultiple << endl;
  }
}

// To find all the prime numbers less than or equal to a given integer n by
// Eratosthenes' method:
void SieveOfEratosthenes(int n, vector<int> &primes) {

  // 1.) Create a list of consecutive integers from 2 through n: (2, 3, 4, ..., n).
  int sieve[n] = {0};

  // 2.) Initially, let p equal 2, the smallest prime number.
  for (int p = 2; p < n; p++) {
    if (sieve[p] == 0) {
      primes.push_back(p);

      // 3.) Enumerate the multiples of p by counting to n from p^2 in
      //     increments of p, and mark them in the list, as all the smaller
      //     multiples of p will have already been marked at that point.
      for (int j = p*p; j <= 50; j+=p) {
        sieve[j] = 1;
      }
    }
  }
}