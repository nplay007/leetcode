class Solution:
    def grayCode(self, n):
        if n == 0: return [0]
        res = []
        n = 1 << n  # total 2^n
        for x in range(n):
            res.append(x ^ x >> 1)
        return res