import time


start = time.time()


def dividable(num):
    for data in range(999, 100, -1):
        m = num / data
        if 99 < m < 1000 and num % data == 0:
            return True
    return False
result = 0
for i in range(999*999, 111*111, -1):
    if str(i) == str(i)[::-1] and dividable(i):
        result = i
        break

time_take = time.time() - start
print "The sum is %s and take time is %f" % (result, time_take)
