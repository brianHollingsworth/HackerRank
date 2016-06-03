/**
 * VirtualFunctions.cpp
 *
 * - In this problem, you are given four integers: N, S, P, Q. You will use them
 *   in order to create the sequence 'a' with the following pseudo-code.
 *   a[0] = S (modulo^31)
 *   for i = 1 to N-1
 *      a[i] = a[i-1]*P+Q (modulo 2^31)
 *   Your task is to calculate the number of distinct integers in the sequence
 *   'a'.
 *
 * Input: Four space separated integers on a single line, N, S, P, and Q
 *        respectively.
 *
 * Output: A single integer that denotes the number of distinct integers in the
 *         sequence 'a'.
 */

#include <cstdio>
#include <cstdint>
#include <vector>
#include <iostream>
using namespace std;

int main() {

   // mod31 will hold the value of a 64-bit type casted 1 mod 31.
   uint64_t mod31  = (uint64_t)1 << 31;
   uint64_t n, s, p, q;
   cin >> n >> s >> p >> q;

   // 'previous' will hold place of i-1 in the sequence.
   uint64_t modulo = mod31 - 1;
   vector<bool> a(modulo);
   uint64_t previous = s & modulo;

   a[0] = true;
   int distinctIntegers = 1;

   // Since we already defined a[0], we will begin at the 1 position.
   for (int i = 1; i < n; i++) {
      uint64_t cur_int = (((previous * p) & modulo) + q) & modulo;

      // If the current integer exists in the sequence...
      if (a[cur_int]) {
         break;
      }

      // Otherwise, we have a unique integer.
      a[cur_int] = true;
      distinctIntegers++;
      previous = cur_int;
   }

   cout << distinctIntegers << endl;

   return 0;
 }
