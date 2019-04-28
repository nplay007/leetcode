import time
from euler import prime_factors


start = time.time()
result = max(prime_factors(600851475143))
time_take = time.time() - start

print "The sum is %s and take time is %f" % (result, time_take)