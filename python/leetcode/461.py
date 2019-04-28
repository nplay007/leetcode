class Solution(object):
    def hammingDistance(self, x, y):
        n, res = x ^ y, 0
        while n:
            n &= (n - 1)
            res += 1
        return res