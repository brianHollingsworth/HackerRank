# Here are the test scores of 10 students in physics and history:
#
# Physics Scores  15 12 8  8  7  7  7  6  5 3
# History Scores  10 25 17 11 13 17 20 13 9 15
# Compute Karl Pearson's coefficient of correlation between these scores.
# Compute the answer correct to three decimal places.
#
# Output Format: In the text box, enter the floating point/decimal value
#                required. Do not leave any leading or trailing spaces. Your
#                answer may look like: 0.255.
#
# Referenced http://www.stat.wmich.edu/s216/book/node122.html to create readable
# code.

import math

# Physics will be our X, and History will be our Y
x = [15, 12, 8, 8, 7, 7, 7, 6, 5, 3]
y = [10, 25, 17, 11, 13, 17, 20, 13, 9, 15]

xSum = sum(x)
ySum = sum(y)

n = len(x)

xySum = xSquaredSum = ySquaredSum = 0
for i in range(n):
    xySum += x[i] * y[i]
    xSquaredSum += x[i]**2
    ySquaredSum += y[i]**2

r = (xySum - ((xSum) * (ySum) / n)) / (math.sqrt((xSquaredSum - ((xSum**2) / n)) * (ySquaredSum - ((ySum**2) / n))))

print('%.3f' % r)
