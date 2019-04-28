import time


start = time.time()
m = 1
for i in xrange(1, 101):
    m *= i
result = sum(map(int, str(m)))
spend = time.time() - start
print "The result is %s and take time is %f" % (result, spend)