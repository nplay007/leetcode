import time

start = time.time()
result = 1
for i in range(3,1002,2):
    result += 4 * i ** 2 - 6 * i + 6 # for each retangle with n the sum is : 4n2-6n+6
spend = time.time() - start
print "The result is %s and take time is %f" % (result, spend)