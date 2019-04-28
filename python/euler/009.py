import time
from euler import pythagorean

start = time.time()
result = 0
for a in range(1, 1000):
    for b in range(a + 1, 1000):  # b > a
        c = 1000 - a - b
        if c > b and a * a + b * b == c * c:
            result = a * b * c
            break
time_take = time.time() - start
print "The sum is %s and take time is %f" % (result, time_take)


start = time.time()
result = 0
for a, b, c in pythagorean(1000):
    if a + b + c == 1000:
        result = a * b * c
        break
time_take = time.time() - start
print "The sum is %s and take time is %f" % (result, time_take)