class Solution(object):
    def toHex(self, num):
        if num == 0: return "0"
        elif num < 0: num += 1 << 32
        converthex, res = ["0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"], ""
        while num: num, res = num//16, converthex[num%16]+res
        return res