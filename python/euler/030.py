import time


start = time.time()

result = []
for i in range(2, 9**6+1):
    if i == sum(x**5 for x in map(int, str(i))):
        result.append(i)

spend = time.time() - start
result = sum(result)
print "The result is %s and take time is %f" % (result, spend)