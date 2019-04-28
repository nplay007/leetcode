class Solution(object):
    def lengthOfLastWord(self, s):
        if not s:
            return 0
        i, res = len(s) - 1, 0
        while i >= 0 and s[i] == ' ':
            i -= 1
        while i >= 0 and s[i] != ' ':
            i -= 1
            res += 1
        return res
