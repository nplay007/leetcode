import time
from euler import prime_sieve

start = time.time()

result = 1
for i in prime_sieve(20):
    result *= i

result = result*2*2*2*3
# from 1-20 they are prime:2,3,5,7,11,13,17,19
# analysis the other we need 2**4 and 3**2
time_take = time.time() - start
print "The sum is %s and take time is %f" %(result , time_take)
