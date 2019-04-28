from euler import prime_sieve
import time 


start = time.time()

result = sum(prime_sieve(2 * 10 ** 6))
time_take = time.time() - start
print "The sum is %s and take time is %f" % (result, time_take)
