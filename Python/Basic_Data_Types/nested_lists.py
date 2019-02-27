# Nested Lists
#
# In this problem, given the names and grades for each student in a Physics
# class of N students, store them in a nested list and print the name(s) of any
# student(s) having the second lowest grade.
#
# - Input: The first line contains an integer, N, the number of students. The 2N
#          subsequent lines describe each student over 2 lines; the first line
#          contains a student's name, and the second line contains their grade.
#
# - Output: Print the name(s) of any student(s) having the second lowest grade
#           in Physics; if there are multiple students, order their names
#           alphabetically and print each one on a new line.

students = [[raw_input(), float(raw_input())] for i in xrange(int(raw_input()))]

# To find the second lowest grade, we'll simply take the student in the 1
# position. This will return a single set like so, [name, grade]
secondLowestGrade = sorted(set([physicsGrade[1] for physicsGrade in students]))

# In order to consider multiple students with the second lowest grade, we will
# parse through the list of students and print any students who have the same
# grade as secondLowestGrade
for name in sorted(sameGrade[0] for sameGrade in students if sameGrade[1] == secondLowestGrade[1]):
    print name
