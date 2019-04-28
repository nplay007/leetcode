from euler import is_factorials
import time


# start = time.time()
# result = sum(x for x in range(3, 10**6*3) if is_factorials(x))
# time_spend = time.time() - start
# print "The result is %d and time used is:%f s" % (result, time_spend)



factarry = [1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362800]
def isfactorials(num):
    data = map(int,str(num))
    sumdata = 0
    for item in data:
        sumdata += factarry[item]
    return sumdata == num
start = time.time()
re = sum(x for x in range(3,10**6*3) if isfactorials(x))
time_spend = time.time()-start
print "The result is %d and time used is:%f s" %(re, time_spend)
