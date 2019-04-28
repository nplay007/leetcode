class Solution:
    def titleToNumber(self, s):
        return reduce(lambda x, y : x * 26 + y, [ord(c) - 64 for c in list(s)])

class Solution:
    def titleToNumber(self, s):
        res = 0
        for ch in s:
            res = 26 * res + ord(ch) - ord('A') + 1
        return res
