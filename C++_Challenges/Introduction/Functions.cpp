/**
 * Functions.cpp
 *
 * - In this problem, I am to write a function 
 *   'int max_of_four(int a, int b, int c, int d)', which reads four arguments
 *   and returns the greatest of them.
 * - Input: Four space-separated integers: a, b, c, d.
 * - Output: The greatest of the four integers.
 */

#include <iostream>
#include <cstdio>
using namespace std;

int max_of_four(int a, int b, int c, int d) {
   int max = a;

   if (b > max)
      max = b;
   if (c > max)
      max = c;
   if (d > max)
      max = d;

   return max;
}

int main() {
    int a, b, c, d;
    scanf("%d %d %d %d", &a, &b, &c, &d);
    int ans = max_of_four(a, b, c, d);
    printf("%d", ans);
    
    return 0;
}