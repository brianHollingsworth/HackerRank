/**
 * Sparse Array
 *
 * - There are N strings. Each string's length is no more than 20 characters.
 *   There are also Q queries. For each query, you are given a string, and you
 *   need to find out how many times this string occurred previously.
 *
 * - Input: The first line contains N, the number of strings.
 *          The next N lines each contain a string.
 *          The N+2nd line contains Q, the number of queries.
 *          The following Q lines each contain a query string.
 *
 * - Output: The number of respective occurrences for each string.
 */

using System;
using System.Collections.Generic;
using System.IO;
class SparseArray {
   static void Main(String[] args) {
      int n = Convert.ToInt32(Console.ReadLine());

      string[] originalStrings = new string[1000];
      for (int i = 0; i < n; i++) {
         originalStrings[i] = Console.ReadLine();
      }

      int q = Convert.ToInt32(Console.ReadLine());

      while (q > 0) {
         string query    = Console.ReadLine();
         int occurrences = 0;

         foreach (string originalString in originalStrings) {
            if (String.Equals(originalString, query, StringComparison.Ordinal)) {
               occurrences++;
            }
         }

         Console.WriteLine(occurrences);

         q--;
      }
   }
}
