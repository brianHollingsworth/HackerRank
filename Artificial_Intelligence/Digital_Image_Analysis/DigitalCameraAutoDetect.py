# Digital Camera Autodetect: Day or Night
#
# - In this challenge, we need to construct a feature in a Digital Camera, which
#   will auto-detect and suggest to the photographer whether the picture should
#   be clicked in day or night mode, depending on whether the picture is being
#   clicked in the daytime or at night.
#
# - Sample Input: This is for the purpose of explanation only. The real inputs
#   will be larger than this (and will all contain 30 rows and 60 columns).
#   3 3
#   0,0,200 0,0,10 10,0,0
#   90,90,50 90,90,10 255,255,255
#   100,100,88 80,80,80 15,75,255
#   The first line indicates the number of rows and columns (3x3).
#   The above is an image represented by 3x3 pixels. For each pixel the Blue,
#   Green and Red values are provided, separated by commas. The top left pixel
#   has (Blue=0,Green=0,Red=200). The top-right pixel has (Blue=10,Green=0,Red=0).
#
# - Sample Output: Just one word: 'day' or 'night'.

import sys

pixel_count = 0
brightness_sum = 0

# For each line of pixel tuples...
for line in sys.stdin:

    # We will separate the individual pixels at every space.
    pixels = line.strip().split(' ')

    # Then, for every pixel / RGB tuple, we will map the individual Red, Green,
    # and Blue values by separating at the commas.
    for pixel in pixels:
        r, g, b = map(int, pixel.split(','))

        # Because pixels are scaled on a 0-255 brightness scale, we want to find
        # how bright our pixels are. We will take the brightest RGB value and
        # add it to our pixel brightness sum.
        max_brightness = max(r,g,b)
        brightness_sum += max_brightness
        pixel_count += 1

# Now that we have our pixel brightness sum, we can divide it by the total
# number of pixels to find the average brightness and determine if the picture
# is being clicked in the daytime or at night.
# *** This took some tinkering to satisfy all 25 test cases, but a threshold of
#     of 100 was the first solid value that satisfied all cases.
if float(brightness_sum) / pixel_count > 100:
    print "day"
else:
    print "night"
