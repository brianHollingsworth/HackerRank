/**
 * Arrays.cpp
 *
 * - In this problem, given an array, A, of N integers, print each element in
 *   reverse order as a single line of space-separated integers.
 *
 * Input: The first line contains an integer, N. The second line contains N
 *        space-separated integers describing A.
 *
 * Output: Print all N integers in A in reverse order as a single line of space-
 *         separated integers.
 */

#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;
    int a[n];
    for (int i = 0; i < n; i++) {
       cin >> a[i];
    }
    for (int j = n-1; j >= 0; j--) {
       cout << a[j] << " ";
    }
    return 0;
}
