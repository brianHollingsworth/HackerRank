/**
 * OperatorOverloading.cpp
 *
 * - In this problem, you are given a main() function which takes a set of
 *   inputs to create two matrices and prints the result of their addition. You
 *   need to write the class Matrix which has a member 'a' of type
 *   vector<vector<int>>. You also need to write a member function to overload
 *   the operator +. The function's job will be to add two objects of Matrix
 *   type and return the resultant Matrix.
 *
 * Input: First line will contain the number of test cases T. For each test
 *        case, there are three lines of input.
 *        The first line of each test case will contain two integers N and M
 *        which are the sizes of the rows and columns, respectively, of the two
 *        matrices that will follow on the next two lines. These next two lines
 *        will each contain N * M elements of both the matrices in a row-wise
 *        format.
 *
 * Output: The code provided in the editor will use your class 'Matrix' and
 *         overloaded operator function to add the two matrices and give the
 *         output.
 */

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

class Matrix {
public:
   vector<vector<int> > a;
   Matrix operator+(const Matrix& b);
};

Matrix Matrix::operator+(Matrix &b) {
   for (int i = 0; i != a.size(); i++) {
      for (int j = 0; j != a[0].size(); j++) {
         a[i][j] += b.a[i][j];
      }
   }
   return *this;
}

int main(int argc, char const *argv[]) {
   int cases, k;
   cin >> cases;

   for (k = 0; k < cases; k++) {
      Matrix x;
      Matrix y;
      Matrix result;
      int n,m,i,j;
      cin >> n >> m;

      for (i = 0; i < n; i++) {
         vector<int> b;
         int num;
         for (j = 0; j < m; j++) {
            cin >> num;
            b.push_back(num);
         }
         x.a.push_back(b);
      }
      for (i = 0; i < n; i++) {
         vector<int> b;
         int num;
         for (j = 0; j < m; j++) {
            cin >> num;
            b.push_back(num);
         }
         y.a.push_back(b);
      }
      result = x + y;

      for (i = 0; i < n; i++) {
         for (j = 0; j < m; j++) {
            cout << result.a[i][j] << " ";
         }
         cout << endl;
      }
   }
   return 0;
}
