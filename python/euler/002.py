# /usr/bin/env/python
import time
from euler import fibonacci_n, fibonacci
from itertools import takewhile


start = time.time()
result = sum(x for x in fibonacci_n(4*10**6) if x % 2 == 0)
time_spend = time.time() - start

print "The sum is %s and take time is %f" % (result, time_spend)

start = time.time()
result = sum(x for x in takewhile(lambda x: x < 4*10**6, fibonacci()) if x % 2 == 0) # take while is helpful
time_spend = time.time() - start

print "The sum is %s and take time is %f" % (result, time_spend)