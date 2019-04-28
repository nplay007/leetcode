import time


start = time.time()
result = set(a**b for a in range(2, 101) for b in range(2, 101))

spend = time.time() - start
print "The result is %s and take time is %f" % (len(result), spend)