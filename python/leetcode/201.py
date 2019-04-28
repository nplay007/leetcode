class Solution:
    def rangeBitwiseAnd(self, m, n):
        result = 0
        while m != n:
            m >>= 1
            n >>= 1
            result += 1
        return n << result