from euler import prime_sieve,isprime
import time

def is_square(n):
    x = int((n/2)**0.5)
    if 2*x*x == n:
        return True
    else:
        return False

start = time.time()
num = 3
result = 0
while True:
    flag = False
    if not isprime(num):
        for item in prime_sieve(num):
            if is_square(num-item):
                flag = True
                break
        if not flag:
            result = num
            break
    num += 2
spend = time.time() - start
print "The result is %s and take time is %f" % (result, spend)