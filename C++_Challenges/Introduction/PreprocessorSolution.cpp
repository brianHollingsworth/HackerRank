/**
 * PreprocessorSolution.cpp
 *
 * - In this problem, you're spending your afternoon at a local school, teaching
 *   kids how to code. You give them a simple task: find the difference between
 *   the maximum and minimum values in an array of integers.
 *
 *   After a few hours, they came up with some promising source code.
 *   Unfortunately, it doesn't compile! Since you don't want to discourage them,
 *   you decide to make their code work without modifying it by adding
 *   preprocessor macros.
 *
 * Input: The first line contains an integer, N, denoting the size of the array.
 *        The second line contains N space-separated integers, x1, x2, ..., xn,
 *        describing the elements in the array
 * Output: Once the necessary preprocessor macros are written, the locked code
 *         in your editor will print a line that says Result = Z, where Z is the
 *         difference between the maximum and minimum values in the array.
 */

#define foreach(i,j) for(int j = 0; j < i.size(); j++)
#define FUNCTION(minOrMax,symbol) void minOrMax(int& x, int y){if(!(x symbol y)) x = y;}

// -10^8 <= xi <= 10^8
#define INF 100000000
#define io(v) cin >> v
#define toStr(s) #s

#include <iostream>
#include <vector>
using namespace std;

#if !defined toStr || !defined io || !defined FUNCTION || !defined INF
#error Missing preprocessor definitions
#endif

FUNCTION(minimum, <)
FUNCTION(maximum, >)

int main() {
   int n;
   cin >> n;
   vector<int> v(n);
   foreach(v, i) {
      io(v)[i];
   }
   int mn = INF;
   int mx = -INF;
   foreach(v, i) {
      minimum(mn, v[i]);
      maximum(mx, v[i]);
   }
   int ans = mx - mn;
   cout << toStr(Result =) << ' ' << ans;
   return 0;
 }
