class Solution(object):
    def convertToTitle(self, n):
        res = ""
        while n:
            res = chr((n-1)%26 + ord('A')) + res 
            # 1 + (n-1)%26 + ord('A') - 1
            n = (n-1)/26 # avoid 26
        return res