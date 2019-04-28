import time
from euler import fibonacci

start = time.time()
result = 0
gen = fibonacci(10**1000)
i = 0
while True:
    num = gen.next()
    i += 1
    if len(str(num)) > 999:
        result = i
        break
spend = time.time() - start
print "The result is %s and take time is %f" % (result, spend)