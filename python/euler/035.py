from euler import isprime
from euler import prime_sieve
import time


def circular(n):
    num = str(n)
    for i in range(len(str(n))):
        cirnum = int(num[i:]+num[:i])
        if not isprime(cirnum):
            return False
    return True

start = time.time()
result = sum([1 for i in prime_sieve(10**6) if circular(i)])
time_spend = time.time()-start
print "The result is %d and time used is:%f s" %(result, time_spend)