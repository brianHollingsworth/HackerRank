/**
 * You are given a list of size N, initialized with zeroes. You have to perform
 * M operations on the list and output the maximum of final values of all N
 * elements in the list. For every operation, you are given three integers a, b
 * and k. You have to add value k to all the elements ranging from index a to b
 * (both inclusive).
 *
 * Input Format: First line will contain two integers N and M separated by a
 *               single space. The next M lines will contain three integers a, b
 *               and k separated by a single space. Numbers in list are numbered
 *               from 1 to N.
 *
 * Output Format: A single line containing maximum value in the updated list.
 *
 * Sample Input:
 * 5 3
 * 1 2 100
 * 2 5 100
 * 3 4 100
 *
 * Sample Output:
 * 200
 *
 * Explanation:
 * After first update list will be 100 100 0 0 0.
 * After second update list will be 100 200 100 100 100.
 * After third update list will be 100 200 200 200 100.
 * So the required answer will be 200.
 */

#include <iostream>
using namespace std;

int main() {

   long long n, m, a, b, k = 0;
   cin >> n >> m;
   long long *list = new long long[n]();

   for (int i = 0; i < m; i++) {
      cin >> a >> b >> k;

      // When iteratively walking through this problem's description, the
      // extremely large test cases (where m >= 100000), HackerRank would
      // terminate the test case due to a timeout. Thus, to handle these extreme
      // test cases as well as all other test cases, we can avoid HackerRank's
      // timeout by taking advantage of the prefix sum. This is implemented by
      // adding k to [a - 1] and -k to [b].
      list[a - 1] = list[a - 1] + k;
      list[b] = list[b] - k;
   }

   // After all updates are completed, all we have to do is find the index with
   // the largest prefix sum, which will be equivalent to the maximum value in
   // the updated list.
   long long prefixSum = 0, max = 0;
   for (int i = 0; i < n; i++) {
      prefixSum = prefixSum + list[i];
      if (prefixSum > max) {
         max = prefixSum;
      }
   }

   cout << max << endl;
   return 0;
}
