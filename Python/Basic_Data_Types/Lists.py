# Lists
#
# Consider a list (list = []). You can perform the following commands:
#
# insert i e: Insert integer e at position i.
# print: Print the list.
# remove e: Delete the first occurrence of integer e.
# append e: Insert integer e at the end of the list.
# sort: Sort the list.
# pop: Pop the last element from the list.
# reverse: Reverse the list.
#
# Initialize your list and read in the value of n followed by n lines of
# commands where each command will be of the types listed above. Iterate through
# each command in order and perform the corresponding operation on your list.
#
# - Input: The first line contains an integer, n, denoting the number of
#          commands. Each line i of the n subsequent lines contains one of the
#          commands described above.
#
# - Output: For each command of type print, print the list on a new line.

import sys

array = []

# Read the number of commands and create range for loop
for i in range(int(raw_input())):
    command = raw_input().split()

    # We need to convert the parameters for commands like insert, remove, and
    # append to integers.
    for j in range(1, len(command)):
        command[j] = int(command[j])

    if command[0]   == "insert":
        array.insert(command[1], command[2])
    elif command[0] == "print":
        print array
    elif command[0] == "remove":
        array.remove(command[1])
    elif command[0] == "append":
        array.append(command[1])
    elif command[0] == "sort":
        array.sort()
    elif command[0] == "pop":
        array.pop()
    elif command[0] == "reverse":
        array.reverse()
