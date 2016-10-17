/**
 * Left Rotation
 *
 * - Given an array of n integers and a number, d, perform d left rotations on
 *   the array. Then, print the updated array as a single line of space-
 *   separated integers.
 *
 * - Input: The first line contains two space-separated integers denoting the
 *          respective values of n (the number of integers) and d (the number of
 *          left rotations you must perform).
 *          The second line contains n space-separated integers describing the
 *          respective elements of the array's initial state.
 *
 * - Constraints: 1 <= d <= n
 *
 * - Output: Print a single line of n space-separated integers denoting the
 *           final state of the array after performing d left rotations.
 */

using System;
using System.Collections.Generic;
using System.IO;

class LeftRotation {

   static void Main(String[] args) {
      string[] nAndD = Console.ReadLine().Split();
      int n          = int.Parse(nAndD[0]);
      int d          = int.Parse(nAndD[1]);

      string[] input = Console.ReadLine().Split();
      int[] initial  = new int[n];

      for (int i = 0; i < n; i++) {
         initial[i] = int.Parse(input[i]);
      }

      int[] final = new int[n];

      /**
       * I started to have timeout issues making the rotations one-by-one;
       * thus, I needed to take a more intuitive approach to calculating the
       * final position for each integer.
       * Because we are given the constraint 1 <= d <= n, we can take d % n
       * and receive a number of rotations that will result in the same final
       * array as we would get from 'd' rotations. For instance, in the first
       * test case with n = 4 and d = 5, doing one left rotation on an array
       * of four integers is the same as doing a single left rotation.
       */
      d = d % n;

      for (int i = 0; i < n; i++) {
         int newPosition    = (i + n - d) % n;
         final[newPosition] = initial[i];
      }

      foreach (int integer in final) {
         Console.Write(integer + " ");
      }
   }
}
