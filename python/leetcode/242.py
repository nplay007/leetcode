class Solution(object):
    def isAnagram(self, s, t):
        if len(s) != len(t): return False
        words = [0] * 256
        for ch in s: words[ord(ch) - ord('a')] += 1
        for ch in t: words[ord(ch) - ord('a')] -= 1
        if any(words): return False
        return True
