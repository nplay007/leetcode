class Solution(object):
    def isScramble(self, s1, s2):
        from collections import Counter
        if s1 == s2: return True
        if len(s1) != len(s2): return False
        l1, l2 = Counter(s1), Counter(s2)
        if l1 != l2: return False
        n = len(s1)
        for i in range(1, n):
            if self.isScramble(s1[:i], s2[:i]) and self.isScramble(s1[i:], s2[i:]):
                return True
            if self.isScramble(s1[:i], s2[n-i:]) and self.isScramble(s1[i:], s2[:n-i]):
                return True
        return False