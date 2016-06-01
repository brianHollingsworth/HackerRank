/**
 * InputAndOutput.cpp
 *
 * - In this problem, read three numbers from stdin and print their sum to stdout.
 */

#include <cstdio>
#include <iostream>
using namespace std;

int main() {

    int total = 0;
    for (int i = 0; i < 3; i++) {
      int value;
      cin >> value;
      total+=value;
    }
    cout << total << endl;
    return 0;
}
