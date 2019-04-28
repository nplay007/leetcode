import time


start = time.time()
result = abs(sum(x**2 for x in range(1, 101)) - (sum(x for x in range(1, 101)))**2)

time_take = time.time() - start
print "The sum is %s and take time is %f" % (result, time_take)