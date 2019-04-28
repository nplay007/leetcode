from euler import ispalidromes
import time


start = time.time()
result = sum(x for x in range(10**6) if ispalidromes(str(x)) and ispalidromes(bin(x)[2:]))
time_spend = time.time() - start

print "The result is %d and time used is:%f s" %(result, time_spend)