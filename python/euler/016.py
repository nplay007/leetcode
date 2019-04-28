import time


start = time.time()
result = sum(map(int, str(2 ** 1000)))

timetake = time.time() - start
print "The result is %s and take time is %f" % (result, timetake)

