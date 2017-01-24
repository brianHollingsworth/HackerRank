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

xy_sum = x_squared_sum = 0
for i in range(n):
    xy_sum += x[i] * y[i]
    x_squared_sum += x[i]**2

# a = The intercept point of the regression line and the y-axis.
# b = The slope of the regression line.
a = (sum(y) * (x_squared_sum) - sum(x) * xy_sum) / (n * x_squared_sum -
    sum(x)**2)
b = ((n * xy_sum - sum(x)*sum(y))/(n * x_squared_sum - sum(x)**2))

# y' = bx + a
# Since we're making a prediction when the student's History score is 10, we set
# 'x' = 10
y_hat = (b*10) + a

print('%.1f' % y_hat)
