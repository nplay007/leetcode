class Solution(object):
    def candy(self, ratings):
        n = len(ratings)
        res = [1 for _ in xrange(n)]
        for i in xrange(1, n):
            if ratings[i] > ratings[i - 1]:
                res[i] = res[i - 1] + 1
        for i in xrange(n - 1, 0, -1):
            if ratings[i - 1] > ratings[i]:
                res[i - 1] = max(res[i - 1], res[i] + 1)
        total = 0
        for item in res:
            total += item
        return total
