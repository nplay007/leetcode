import time

start = time.time()
coinsize = [1, 2, 5, 10, 20, 50, 100, 200]
ways = [0] * 201
ways[0] = 1
for i in range(0,8):
    j = coinsize[i]
    while j <= 200:
        ways[j] += ways[j - coinsize[i]]
        j += 1
result = ways[-1]
spend = time.time() - start
print "The result is %s and take time is %f" % (result, spend)

