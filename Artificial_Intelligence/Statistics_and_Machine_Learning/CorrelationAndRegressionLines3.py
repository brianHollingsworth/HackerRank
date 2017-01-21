# Here are the test scores of 10 students in physics and history:
#
# Physics Scores  15  12  8   8   7   7   7   6   5   3
# History Scores  10  25  17  11  13  17  20  13  9   15
# When a student scores 10 in Physics, what is his or her probable score in
# History? Compute the answer correct to one decimal place.
#
# Output Format: In the text box, enter the floating point/decimal value
#                required. Do not leave any leading or trailing spaces. Your
#                answer may look like: 5.5
#
# Referenced https://www.easycalculation.com/statistics/learn-regression.php to
# better understand linear regression formula and to create readable code.

#import math
from __future__ import division

# Physics will be our X, and History will be our Y
x = [15, 12, 8, 8, 7, 7, 7, 6, 5, 3]
y = [10, 25, 17, 11, 13, 17, 20, 13, 9, 15]

n = len(x)

xySum = xSquaredSum = 0
for i in range(n):
    xySum += x[i] * y[i]
    xSquaredSum += x[i]**2

# a = The intercept point of the regression line and the y-axis.
# b = The slope of the regression line.
a = (sum(y) * (xSquaredSum) - sum(x) * xySum) / (n * xSquaredSum - sum(x)**2)
b = ((n * xySum - sum(x)*sum(y))/(n * xSquaredSum - sum(x)**2))

# y' = bx + a
# Since we're making a prediction when the student's History score is 10, we set
# 'x' = 10
yHat = (b*10) + a

print('%.1f' % yHat)
