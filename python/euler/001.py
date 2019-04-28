# /usr/bin/env/python
import time


start = time.time()
data = sum(x for x in xrange(1, 1000) if x % 3 == 0 or x % 5 == 0)  # list comprehension
time_take = time.time() - start
print "The sum is %s and take time is %f s" % (data, time_take)

