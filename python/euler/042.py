def istriangle(val):
    i = int((-1+(8*val+1)**0.5)/2)
    return i*(i+1)/2 == val

words = open("p042_words.txt").read().replace('"','').split(',')

print sum(1 for item in words if istriangle(sum(map(lambda a:ord(a)-64,item))))