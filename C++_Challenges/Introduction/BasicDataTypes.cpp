/**
 * BasicDataTypes.cpp
 *
 * - In this problem, I focus on the C++ data types along with their respective
 *   format specifiers.
 * - HackerRank's input will consist of an int, long, long long, char, float
 *   and double, each separated by a space.
 * - Each element will be printed in the same order, except each on a new line.
 */

#include <iostream>
#include <cstdio>
using namespace std;

int main() {
   // Complete the code.
   int i;
   long l;
   long long ll;
   char c;
   float f;
   double d;

   scanf("%d %ld %lld %c %f %lf", &i, &l, &ll, &c, &f, &d);
   printf("%d\n%ld\n%lld\n%c\n%f\n%lf\n", i, l, ll, c, f, d);

   return 0;
}
