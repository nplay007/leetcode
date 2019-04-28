class Solution(object):
    def mySqrt(self, x):
        if x <= 1:
            return x
        l, r = 0, x
        while l <= r:
            m = l + (r - l) / 2
            if m * m == x:
                return m
            elif m * m > x:
                r = m - 1
            else:
                l = m + 1
        return r
