class Solution:
    def trailingZeroes(self, n):
        cnts = 0
        while n/5 > 0:
            cnts += n/5
            n /= 5
        return cnts