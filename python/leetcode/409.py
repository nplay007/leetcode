class Solution(object):
    def longestPalindrome(self, s):
        from collections import Counter
        t = Counter(s)
        flag = False
        res = 0
        for key, val in t.iteritems():
            if val % 2 == 1:
                flag = True
            res += val / 2 * 2
        if flag:
            res += 1
        return res
