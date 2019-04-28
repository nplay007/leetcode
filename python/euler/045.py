import time


def triangle(i=1):
        return i * (i + 1) / 2


def pentagonal(i=1):
    return i * (3 * i - 1) / 2


def is_pentagonal(n):
    x = int((24 * n + 1) ** 0.5 + 1)/6
    if x*(3*x-1)/2 == n:
        return True
    else:
        return False

def hexagonal(i=1):
    while True:
        yield i * (2 * i - 1)
        i += 1

def is_hexagonal(n):
    x = int((8 * n + 1) ** 0.5 + 1)/4
    if x*(2*x-1) == n:
        return True
    else:
        return False

start = time.time()
num = 286
result = 0

while True:
    Tnum = triangle(num)
    if is_hexagonal(Tnum) and is_pentagonal(Tnum):
        result = Tnum
        break
    num += 1

spend = time.time() - start
print "The result is %s and take time is %f" % (result, spend)