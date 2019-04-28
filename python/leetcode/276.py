class Solution(object):
    def numWays(self, n, k):
        if n == 0 or k == 0: return 0
        if n == 1: return k
        same, diff = k, k*(k-1)
        for i in range(2, n):
            tmp = (k-1) * (same + diff)
            same = diff
            diff = tmp
        return same + diff