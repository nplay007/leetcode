import time


start = time.time()
names = open('p022_names.txt').read().replace('"', '').split(',')
names.sort()
result = sum(sum(map(lambda c: ord(c) - 64, names[i])) * (i + 1) for i in range(len(names)))
spend = time.time() - start
print "The result is %s and take time is %f" % (result, spend)