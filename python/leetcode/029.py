class Solution:
    def divide(self, dividend, divisor):
        sign = -1 if (dividend < 0) ^ (divisor < 0) else 1
        dvd, dvs = abs(dividend), abs(divisor)
        INT_MAX, INT_MIN = 2 ** 31 - 1, -2 ** 31
        res = 0
        while dvd >= dvs:
            tmp, cnts = dvs, 1
            while dvd >= (tmp << 1):
                tmp <<= 1
                cnts <<= 1
            dvd -= tmp
            res += cnts
        res *= sign
        return res if INT_MIN <= res <= INT_MAX else INT_MAX