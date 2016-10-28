# Finding the Percentage
#
# In this problem, we have a record of N students. Each record contains the
# student's name, and their percent marks in Maths, Physics and Chemistry. The
# marks can be floating values. The user enters some integer N followed by the
# names and marks for N students. We are required to save the record in a
# dictionary data type. The user then enters a student's name. Output the
# average percentage marks obtained by that student, correct to two decimal
# places.
#
# - Input: The first line contains the integer N, the number of students. The
#          next N lines contains the name and marks obtained by that student
#          separated by a space. The final line contains the name of a
#          particular student previously listed.
#
# - Output: Print one line: The average of the marks obtained by the particular
#           student correct to 2 decimal places.

studentRecords = {}

for i in range(int(raw_input())):
    record = raw_input().split()

    # The student name will be used as the dictionary key, and the grades--in
    # the remaining positions of the record--will be used as the values.
    studentRecords[record[0]] = sum(map(float, record[1:]))/3

print '%.2f' % studentRecords[raw_input()]
