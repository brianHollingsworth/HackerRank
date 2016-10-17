/**
 * Dynamic Array
 *
 * - Create a list, seqList, of N empty spaces, where each sequence is indexed
 *   from 0 to N-1. The elements within each of the N sequences also use
 *   0-indexing.
 * - Create an integer, lastAns, and initialize it to 0.
 * - The two types of queries that can be performed on your list of sequences ()
 *   are described below:
 *    1.) Query: 1 x y
 *        a.) Find the sequence, seq, at index ((x XOR lastAns % N)) in seqList.
 *        b.) Append integer 'y' to sequence 'seq'.
 *    2.) Query: 2 x y
 *        a.) Find the sequence, seq, at index ((x XOR lastAns % N)) in seqList.
 *        b.) Find the value of the element 'y % size' in 'seq' (where 'size' is
 *            the size of 'seq') and assign it to 'lastAns'.
 *        c.) Print the new value of 'lastAns' on a new line.
 *
 * - Input: The first line contains two space-separated integers, N (the number
 *          of sequences) and Q (the number of queries), respectively.
 *          Each of the Q subsequent lines contains a query in the format
 *          defined above.
 *
 * - Output: For each type 2 query, print the updated value of 'lastAns' on a
 *           new line.
 */

using System;
using System.Collections.Generic;
using System.IO;

class DynamicArray {
   static void Main(String[] args) {

      string[] nAndQ      = Console.ReadLine().Split();
      int n               = int.Parse(nAndQ[0]);
      int q               = int.Parse(nAndQ[1]);
      List<int>[] seqList = new List<int>[n];
      int lastAns         = 0;

      // Populate seqList with empty spaces, or else we will get out-of-bounds
      // index error.
      for (int i = 0; i < n; i++) {
         seqList[i] = new List<int>();
      }

      for (int i = 0; i < q; i++) {
         string[] query = Console.ReadLine().Split();
         int queryType  = int.Parse(query[0]);
         int x          = int.Parse(query[1]);
         int y          = int.Parse(query[2]);

         List<int> seq = seqList[(x ^ lastAns) % n];

         switch (queryType)
         {
            case 1:
               seq.Add(y);
               seqList[(x ^ lastAns) % n] = seq;
               break;
            case 2:
               lastAns = seq[y % seq.Count];
               Console.WriteLine(lastAns);
               break;
            default:
               Console.WriteLine("Invalid query type.");
               i--;
               break;
         }
      }
   }
}
