class Solution(object):
    def isOneEditDistance(self, s, t):
        if not s and not t: return False
        m, n = len(s), len(t)
        if abs(m - n) > 1: return False
        if m > n: return self.isOneEditDistance(t, s)
        i, diff = 0, n - m
        while i < m and s[i] == t[i] : i += 1
        if diff == 0: # true for one change
            i += 1 # change one char, just skip 
            while i < m and s[i] == t[i]: i += 1
            return i == m
        else: # skip one 
            while i < m and s[i] == t[i+1]: i += 1
            return i == m