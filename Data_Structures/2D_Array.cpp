/**
 * 2D_Array.cpp
 *
 * - In this problem, you are given a 2D array with dimensions 6*6. An hourglass
 *   in an array is defined as a portion shaped like this:
 *   a b c
 *     d
 *   e f g
 * - Print the largest sum among all the hourglasses in the array.
 *
 * Input: There will be exactly 6 lines of input, each containing 6 integers
 *        separated by spaces. Each integer will be between -9 and 9.
 *
 * 1 1 1 0 0 0
 * 0 1 0 0 0 0
 * 1 1 1 0 0 0
 * 0 0 2 4 4 0
 * 0 0 0 2 0 0
 * 0 0 1 2 4 0
 *
 * Output: Print the answer to this problem on a single line.
 */

#include <cstdio>
#include <limits>
#include <vector>
#include <iostream>

using namespace std;

int main() {
    vector< vector<int> > arr(6,vector<int>(6));
    for (int arr_i = 0; arr_i < 6; arr_i++) {
       for (int arr_j = 0; arr_j < 6; arr_j++) {
          cin >> arr[arr_i][arr_j];
       }
    }

    // The "smallest" hourglass can hold -9 in all positions with a sum of -63.
    int sum, largestSum = -64;

    // arr[row][column]
    for (int i = 0; i < 4; i++) {
       for (int j = 0; j < 4; j++) {

          // sum = a + b + c + d +
          //       e + f + g
          sum = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1] +
                arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];

          if (sum > largestSum) {
             largestSum = sum;
          }
       }
    }

    cout << largestSum;
    return 0;
}
