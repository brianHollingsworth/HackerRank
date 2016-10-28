# List Comprehensions
#
# - In this problem, we are given three integers X, Y, and Z representing the
#   dimensions of a cuboid. We have to print a list of all possible coordinates
#   on a 3D grid where the sum of Xi + Yi + Zi is not equal to N. If X=2, the
#   possible values of Xi can be 0, 1, and 2. The same applies to Y and Z.
#
# - Input: Four integers X, Y, Z, and N each on four separate lines,
#          respectively.
#
# - Output: Print the list in lexicographic increasing order.

x = int(raw_input())
y = int(raw_input())
z = int(raw_input())
n = int(raw_input())

coordinates = []

# Using a list comprehension, we can elegantly nest the loops for Xi, Yi, Zi,
# and their sums.
[ coordinates.append([xi,yi,zi]) for xi in range(x+1) for yi in range(y+1)
                                 for zi in range(z+1) if xi+yi+zi != n]

print coordinates
