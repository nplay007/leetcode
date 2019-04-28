from euler import isprime
import time


def quadratic(a, b):
    n = 1
    count = 1
    while True:
        if isprime(n * n + a * n + b):
            n += 1
            count += 1
        else:
            break
    return count

start = time.time()
result = 0
lenab = -1
for a in range(-999, 1000, 1):
    for b in range(2, 1000, 1):  # when n = 0, we get b ; b should be prime
        if isprime(b) and a + b > 0 and isprime(1 + a + b):
            data = quadratic(a, b)
            if data > lenab:
                result = a * b
                lenab = data

spend = time.time() - start
print "The result is %s and take time is %f" % (result, spend)