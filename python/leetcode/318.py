class Solution:
    def maxProduct(self, words):
        n, res = len(words), 0
        masks = [0] * n
        for i in xrange(n):
            for ch in words[i]:
                masks[i] |= 1 << (ord(ch) - ord('a'))
        # each masks[i] has 32 digits which is enough to save 26 characters
        # so masks[i] records each alphabeta characters in words[i]
        for i in xrange(n):
            for j in xrange(i + 1, n):
                if (masks[i] & masks[j]) == 0:
                    res = max(res, len(words[i]) * len(words[j]))
        return res