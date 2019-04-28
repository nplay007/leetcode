import time


start = time.time()


def cal_sum(n):
    return sum([x for x in range(1, n) if n % x == 0])
gen = set()
result = 0
for n in range(1,28123):
    if cal_sum(n) > n:
        gen.add(n)
    if not any((n-a in gen) for a in gen):
        result += n
spend = time.time() - start
print "The result is %s and take time is %f" % (result, spend)
