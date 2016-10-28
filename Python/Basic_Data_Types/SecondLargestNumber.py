# Second Largest Number
#
# In this problem, we are given N numbers. Store them in a list and find the
# second largest number.
#
# - Input: The first line contains N. The second line contains an array A[] of N
#          integers each separated by a space.
#
# - Output: The value of the second largest number.

from sys import maxint

n = int(raw_input())
a = []

[a.append(int(i)) for i in raw_input().split()]

largest, secondLargest = -maxint, -maxint

for i in a:
    if i > largest:
        largest, secondLargest = i, largest
    elif i < largest and i > secondLargest:
        secondLargest = i

print(secondLargest)
