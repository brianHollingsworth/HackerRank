/**
 * ArraysIntroduction.cpp
 *
 * - In this problem, we will be an given array of N integers and you have to
 *   print the integers in the reverse order.
 *
 * Input: The first line of the input contains N, where N is the number of
 *        integers. The next line contains N integers separated by a space.
 * Output: Print the N integers of the array in the reverse order in a single
 *         line separated by a space.
 */

#include <cstdio>
#include <iostream>
using namespace std;

int main() {

    int n;
    cin >> n;
    int array[n];
    for (int i = 0; i < n; i++) {
       cin >> array[i];
    }

    for (int j = n-1; j >= 0; j--) {
       cout << array[j] << " ";
    }
    cout << endl;
    return 0;
}
