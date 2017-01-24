# Here are the test scores of 10 students in physics and history:
#
# Physics Scores  15  12  8   8   7   7   7   6   5   3
# History Scores  10  25  17  11  13  17  20  13  9   15
# Compute the slope of the line of regression obtained while treating Physics as
# the independent variable. Compute the answer correct to three decimal places.
#
# Output Format: In the text box, enter the floating point/decimal value
#                required. Do not leave any leading or trailing spaces. Your
#                answer may look like: 0.255.
#
# Referenced https://people.richland.edu/james/lecture/m170/ch11-reg.html and
# https://www.youtube.com/watch?v=GAmzwIkGFgE to understand formula and to
# create readable code.

#import math
from __future__ import division

# Physics will be our X, and History will be our Y
x = [15, 12, 8, 8, 7, 7, 7, 6, 5, 3]
y = [10, 25, 17, 11, 13, 17, 20, 13, 9, 15]

x_mean = sum(x) / len(x)
y_mean = sum(y) / len(y)

n = len(x)

xy_sum = xy_mean = 0
for i in range(n):
    xy_sum += x[i] * y[i]

xy_mean = xy_sum / n

x_mean_squared = x_mean**2

x_squares = mean_of_x_squares = 0
for i in range(n):
    x_squares += x[i]**2

mean_of_x_squares = x_squares / n

slope = (xy_mean - ((x_mean) * (y_mean))) / (mean_of_x_squares - (x_mean**2))

print('%.3f' % slope)
