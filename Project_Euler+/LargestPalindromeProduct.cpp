/**
 * Project Euler #4: Largest Palindrome Product 
 * A palindromic number reads the same both ways. The smallest 6 digit
 * palindrome made from the product of two 3-digit numbers is 101101 = 143*707.
 * Find the largest palindrome made from the product of two 3-digit numbers
 * which is less than N. 
 *
 * Input Format: First line contains T that denotes the number of test cases.
 *               This is followed by T lines, each containing an integer, N.
 *
 * Output Format: Print the required answer for each test case in a new line.
 */

#include <cmath>
#include <cstdio>
#include <iostream>
#include <algorithm>
using namespace std;

// A function for efficiently determining whether or not 'n' is a palindrome.
bool IsPalindrome(int n);

int main() {
  int t;
  cin >> t;
  for (int i = 0; i < t; i++) {
    int n;
    cin >> n;

    bool product_of_two_three_digit_numbers = false;
    int largest_palindrome_product = 0;
    for (int j = 1; j < 1000; j++) {
      for (int k = 1; k < 1000; k++) {
        if (j * k < n && IsPalindrome(j * k)) {
          if (j * k > largest_palindrome_product) {
            largest_palindrome_product = j * k;
          }
        }
      }
    }
    cout << largest_palindrome_product << endl;
  }
  
  return 0;
}

// To prevent the timeouts in HackerRank, we have to think a little more
// intuitively. This new algorithm will search end-to-end from the outside, in.
bool IsPalindrome(int n) {

  bool is_palindrome = true;

  // temp       : A temporary value that will act as a counter for finding the
  //              number of digits in 'n'.
  // front_digit: A value that will act as a marker in our search that begins at
  //              at the front of 'n' and will move from left to right.
  // end_digit  : A value that represents the number of digits in 'n' as well as
  //              the right-most position of the search. We will multiply it by
  //              10 for every decimal place (10 = 1 digit, 100000 = 5 digits).
  //              This will be handy when we use mod.
  int temp = n;
  int front_digit = 1;
  int end_digit = 1;

  while (temp != 0) {
    temp /= 10;
    end_digit *= 10;
  }
  end_digit /= 10;

  // While the front digit marker stays to the left of the end digit marker...
  while (front_digit < end_digit) {

    // Check to see if the front marker and the end marker match or not. If not,
    // we don't have a palindrome.
    if ((n / front_digit) % 10 != (n / end_digit) % 10) {
      is_palindrome = false;
      break;
    }

    // Move the front marker to the right and the right marker to the left.
    front_digit *= 10;
    end_digit /= 10;
  }

  return is_palindrome;
}

// This old algorithm I used in college worked with test case #0, but it was
// causing test cases #1, #2, and #3 to terminate due to timeout, so I needed to
// rework my thinking.
// bool IsPalindrome(int n) {
//   bool is_palindrome = true;
//
//   string n_string = to_string(n);
//   int length = n_string.length();
//
//   for (int i = 0; i < length; i++){
//     if (n_string[i] != n_string[length-i-1]) {
//       is_palindrome = false;
//       break;
//     }
//   }
//
//   return is_palindrome; 
// }