import time

start = time.time()
d = {1: 1}


def nterms(n):
    return d[n] if n in d else d.setdefault(n, 1 + (nterms(3 * n + 1) if n % 2 else nterms(n / 2)))

result = max((nterms(n), n) for n in range(2, 10 ** 6))[1]
timetake = time.time() - start
print "The result is %s and take time is %f" % (result, timetake)


