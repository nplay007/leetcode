class Solution:
    def shortestDistance(words, word1, word2):
        n, idx1, idx2, dist = len(words), -1, -1, 2**31
        for i in xrange(n):
            if words[i] == word1: idx1 = i
            elif words[i] == word2: idx2 = i
            if idx1 != -1 and idx2 != -1:
                dist = min(dist, abs(idx1 - idx2))
        return dist