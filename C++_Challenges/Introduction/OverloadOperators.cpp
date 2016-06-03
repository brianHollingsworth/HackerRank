/**
 * OverloadOperators.cpp
 *
 * THIS IS A DIFFERENT CHALLENGE THAN "OperatorOverloading.cpp"
 *
 * - In this problem, you need to overload operators + and << for the Complex
 *   class.
 *   The operator + should add complex numbers according to the rules of complex
 *   addition: (a+ib)+(c+id) = (a+c) + i(b+d)
 *
 * Input: The overloaded operator + should receive two complex numbers (a+ib and
 *        c+id) as parameters.
 *
 * Output: A single complex number.
 */

#include <iostream>
using namespace std;

class Complex {
public:
   int a,b;
   void input(string s) {
      int v1 = 0;
      int i = 0;
      while (s[i] != '+') {
         v1 = v1 * 10 + s[i] - '0';
         i++;
      }
      while (s[i] == ' ' || s[i] == '+' || s[i] == 'i') {
         i++;
      }
      int v2 = 0;
      while (i < s.length()) {
         v2 = v2 * 10 + s[i] - '0';
         i++;
      }
      a = v1;
      b = v2;
   }
};

//Overload operators + and << for the class complex
//+ should add two complex numbers as (a+ib) + (c+id) = (a+c) + i(b+d)
//<< should print a complex number in the format "a+ib"
Complex operator+(Complex &x, Complex &y) {
   Complex z;
   z.a = x.a + y.a;
   z.b = x.b + y.b;
   return z;
}

ostream& operator<<(ostream& stream, const Complex& complex) {
   stream << complex.a << "+i" << complex.b;
   return stream;
}

int main() {
   Complex x,y;
   string s1,s2;
   cin >> s1;
   cin >> s2;
   x.input(s1);
   y.input(s2);
   Complex z = x + y;
   cout << z << endl;
   return 0;
}
