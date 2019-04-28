class Solution(object):
    def hIndex(self, citations):
        n = len(citations)
        if n < 1: return 0
        count = [0 for _ in xrange(n+1)]
        for item in citations:
            count[[item, n][item > n]] += 1
        res = 0
        for i in xrange(n, -1, -1):
            res += count[i]
            if res >= i: return i
        return 0