class Solution:
    def shortestWordDistance(self, words, word1, word2):
        n = len(words)
        res, idx1, idx2 = n, -1, -1
        same = word1 == word2
        for i in xrange(n):
            if words[i] == word1: idx1 = i
            if words[i] == word2:
                if same: idx1 = idx2
                idx2 = i
            if idx1 != -1 and idx2 != -1:
                res = min(res, abs(idx2 - idx1))
        return res