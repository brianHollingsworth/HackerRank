/**
 * VirtualFunctions.cpp
 *
 * - In this problem, create three classes: Person, Professor and Student. The
 *   class Person should have data members name and age. The classes Professor
 *   and Student should inherit from the class Person.
 * - The class Professor should have two data members: publications and
 *   cur_{id}. There will be two member functions: getdata and putdata. The
 *   function getdata should get the input from the user: the name, age and
 *   publications of the professor. The function putdata should print the name,
 *   age, publications and the cur_{id} of the professor.
 * - The class Student should have two data members: marks, which is an array of
 *   size 6 and cur_{id}. It has two member functions: getdata and putdata. The
 *   function getdata should get the input from the user: the name, age, and the
 *   marks of the student in 6 subjects. The function putdata should print the
 *   name, age, sum of the marks and the cur_{id} of the student.
 * - For each object being created of the Professor or the Student class,
 *   sequential id's should be assigned to them starting from 1.
 *
 * Input: There are two types of input. If the object being created is of the
 *        Professor class, you will have to input the name, age and publications
 *        of the professor.
 *        If the object is of the Student class, you will have to input the
 *        name, age and the marks of the student in subjects.
 *
 * Output: If the object is of type Professor, print the space separated name,
 *         age, publications and id on a new line.
 *         If the object is of the Student class, print the space separated
 *         name, age, the sum of the marks in 6 subjects and id on a new line.
 */

#include <cmath>
#include <cstdio>
#include <iostream>
using namespace std;

class Person {
public:
   string name;
   int age;

   virtual void getdata() = 0;
   virtual void putdata() = 0;
};

class Professor: public Person {
   int publications, cur_id;

   void getdata() {
      cin >> name >> age >> publications;
      static int id = 1;
      cur_id = id++;
   }

   void putdata() {
      cout << name << " " << age << " " << publications << " " << cur_id << endl;
   }
};

class Student: public Person {
   int marks[6];
   int cur_id;

   void getdata() {
      cin >> name >> age;
      for (int i = 0; i < 6; i++) {
         cin >> marks[i];
      }
      static int id = 1;
      cur_id = id++;
   }

   void putdata() {
      int sum = 0;
      for (int i = 0; i < 6; i++) {
         sum += marks[i];
      }
      cout << name << " " << age << " " << sum << " " << cur_id << endl;
   }
};
