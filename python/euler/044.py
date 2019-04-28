def pentagonal(i):
    return i * (3 * i - 1) / 2

def is_pentagonal(n):
    x = int((24 * n + 1) ** 0.5 + 1)/6
    if x*(3*x-1)/2 == n:
        return True
    else:
        return False


i = 2
result = 0
while True:
     for j in range(i-1,0,-1):
         nums = pentagonal(i) + pentagonal(j)
         numm = pentagonal(i) - pentagonal(j)
         if is_pentagonal(nums) and is_pentagonal(numm):
             result = numm
             break
     i += 1
     if result > 0:
         break

print result