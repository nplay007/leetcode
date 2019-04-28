from euler import isprime
import time

start = time.time()
n = 0
for i in range(2, 4*10**6):
    if isprime(i):
        n += 1
    if n > 10000:
        break
time_take = time.time() - start
print "The sum is %s and take time is %f" % (i, time_take)
