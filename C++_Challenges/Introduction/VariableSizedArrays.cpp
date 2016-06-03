/**
 * VariableSizedArrays.cpp
 *
 * - In this problem, you are given N integer sequences and Q queries. Each
 *   query is in the following format: "a b" where a denotes the index of the
 *   sequence, and b denotes the index of the element in that sequence. Your
 *   task is to find the value of the element described in each query.
 *
 * Input: The first line consists of N and Q separated by a space.
 *        The following N lines contains sequences in this format:
 *        "k s0 s1 s2 ... sk-1".
 *        The following Q lines contain queries in this format: "a b".
 *
 * Output: Output Q lines, the i'th line contains the answer of the i'th query.
 */

#include <iostream>
using namespace std;

int main() {

   // Create a variably sized array with 'n' sequences.
   int n, q;
   cin >> n >> q;
   int **sequenceArray = new int*[n];

   // We will have 'q' line(s) of queries that will have two members: a & b.
   int queryArray[q][2];

   for (int i = 0; i < n; i++) {
      int k;
      cin >> k;
      sequenceArray[i] = new int[k];
      for (int j = 0; j < k; ++j) {
         int s;
         cin >> s;
         sequenceArray[i][j] = s;
      }
   }

   // We need to +1 in sequenceVector column, because the first element in the
   // sequence is 'k'; thus, it should be ignored in the search.
   for (int i = 0; i < q; i++) {
      int a, b;
      cin >> a >> b;
      cout << sequenceArray[a][b] << endl;
   }
   return 0;
}
