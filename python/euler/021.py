import time 


start = time.time()


def cal_sum(n):
    return sum([x for x in range(1, n) if n % x == 0])

result = 0
for i in range(1, 10000):
    num = cal_sum(i)
    if num != i and cal_sum(num) == i:
        result += i

spend = time.time() - start
print "The result is %s and take time is %f" % (result, spend)