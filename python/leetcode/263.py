class Solution(object):
    def isUgly(self, num):
        if not num:
            return False
        for p in 2, 3, 5:
            while num % p == 0 < num: 
                num /= p
        return num == 1