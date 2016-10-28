# Tuples
#
# - Given an integer, n, and n space-separated integers as input, create a
#   tuple, t, of those n integers. Then compute and print the result of hash(t).
#
# - Input: The first line contains an integer, n, denoting the number of
#          elements in the tuple. The second line contains n space-separated
#          integers describing the elements in tuple t.
#
# - Output: Print the result of hash(t).

# Even though the vairable n isn't used, it's required in the code, or else the
# HackerRank tests will fail.

n = raw_input()

# Use the built-in tuple() function on space-separated integers.
t = tuple([int(i) for i in raw_input().split()])
print hash(t)
