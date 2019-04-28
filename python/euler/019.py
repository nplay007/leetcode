import time
from calendar import weekday


start = time.time()
result = sum(1 for y in range(1901, 2001) for m in range(1, 13) if weekday(y, m, 1) == 6)
spend = time.time() - start
print "The result is %s and take time is %f" % (result, spend)