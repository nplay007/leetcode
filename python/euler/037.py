from euler import isprime
from euler import prime_sieve
import time


def trunc(n):
    num = str(n)
    for i in range(len(str(n))):
        cirnum = int(num[i:])
        if not isprime(cirnum):
            return False
    for i in range(len(str(n))):
        cirnum = int(num[:len(num)-i])
        if not isprime(cirnum):
            return False
    return True

start = time.time()
result = sum([i for i in prime_sieve(10**6) if trunc(i)]) - 2 - 3 - 5 - 7
time_spend = time.time()-start
print "The result is %d and time used is:%f s" %(result, time_spend)