class Solution(object):
    def romanToInt(self, s):
        if not s:
            return 0
        roman = {"I": 1, "V": 5, "X": 10, "L": 50,
                 "C": 100, "D": 500, "M": 1000}
        res = roman[s[-1]]
        for i in range(len(s) - 2, -1, -1):
            if roman[s[i]] < roman[s[i + 1]]:
                res -= roman[s[i]]
            else:
                res += roman[s[i]]
        return res
