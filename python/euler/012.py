from itertools import count 
import time 

start = time.time()


def tri_number(n):
    """get the nth triangle number"""
    return n*(n+1)/2


def gen_tri_number():
    """triangle number generator"""
    for x in count(1):
        yield tri_number(x)


def get_div_number(num):
    count = 0
    for i in range(1, num + 1):
        if num % i == 0:
            count += 1
    return count

num = gen_tri_number()
result = 0
while True:
    n = num.next()
    if get_div_number(n) > 500:
        result = n
        break

timetake = time.time() - start
print "The sum is %s and take time is %f" % (result, timetake)
