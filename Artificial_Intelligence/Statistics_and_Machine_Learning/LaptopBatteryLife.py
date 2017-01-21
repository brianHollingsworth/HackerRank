# Access Fred’s laptop charging log by reading from the file “trainingdata.txt”.
# The training data file will consist of 100 lines, each with 2 comma-separated
# numbers. The first number denotes the amount of time the laptop was charged
# and the second denotes the amount of time the battery lasted. The training
# data file can be downloaded here: https://s3.amazonaws.com/hr-testcases/399/assets/trainingdata.txt.
# This will be the same training data used when your program is run. The input
# for each of the test cases will consist of exactly 1 number rounded to 2
# decimal places. For each input, output 1 number: the amount of time you
# predict his battery will last.
# Sample Input: 1.50
# Sample Output: 3.00
#
# Referenced https://web.williams.edu/Mathematics/sjmiller/public_html/BrownClasses/54/handouts/MethodLeastSquares.pdf
# (formula 2.3) to better understand method of least squares and to produce
# readable code.
import sys

# The amount of time the laptop was charged will be our 'x' variable.
# The amount of time the battery lasted will our 'y' variable.
chargeTime = []
batteryTime = []

trainingData = open('trainingdata.txt')
for line in trainingData:
    x, y = map(float, line.split(','))

    # I plugged in "trainingdata.txt" as a CSV into Numbers (see
    # trainingdata.numbers), sorted the data by charge time, and plotted the
    # data on a line graph; there was a clear trend in the data. A charge time
    # (x) of 3.99 had a battery time (y) of 7.98, and a charge time of 4.11
    # produced a battery time of 8.00. Thus, it can be concluded that any charge
    # time over 4.00 hours will produce a battery time over 8.00. We will only
    # read in data points where the charge time was less than four hours.
    if (x < 4):
        chargeTime.append(x)
        batteryTime.append(y)

trainingData.close()

n = len(chargeTime)
averageChargeTime = sum(chargeTime) / n
averageBatteryTime = sum(batteryTime) / n

expectedValue = N = 0
for i in xrange(n):
    xiMinusXBar = chargeTime[i] - averageChargeTime
    expectedValue += xiMinusXBar * (batteryTime[i] - averageBatteryTime)
    N += xiMinusXBar**2

b = (1.0 * expectedValue) / N
a = averageBatteryTime - b * averageChargeTime

# Now that we have figured out our method of least squares, we can now quantify
# what we mean by “best fit”. We will analyze a provided input, x, that
# represents an arbitrary charge time.
x = float(raw_input())

# Since the data tells us that any charge time four hours or greater will
# produce a battery time of 8.00, we will only plug in charge times less than
# four hours into the formula, y = ax + b
if (x < 4):
    y = (a + b * x)
    print "%.2f" % y
else:
    print 8.00
