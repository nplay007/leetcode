class Solution:
    def reverse(self, x):
        sign = 1 if x > 0 else -1
        valOfReverse, x = 0, abs(x)
        while x:
            valOfReverse = 10 * valOfReverse + x % 10
            x /= 10
        return sign * valOfReverse if -2**31 < valOfReverse < 2**31 - 1 else 0
