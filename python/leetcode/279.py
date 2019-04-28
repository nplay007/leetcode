class Solution:
    def numSquares(self, n):
        if n <= 0: return 0
        dp = [float("Infinity")] * (n+1)
        dp[0] = 0
        for i in range(1, n+1):
            j = 1
            while j*j <= i:
                dp[i] = min(dp[i], dp[i - j*j] + 1)
                j += 1
        return dp[-1]


class Solution(object):
    def numSquares(self, n):
    if n < 2: return n
    dp = [i *i for i in range(1, n) if i * i <= n]
    cnts, toCheck = 0, {n}
    while toCheck:
        cnts, tmp = cnts + 1, set()
        for x in toCheck:
            for y in dp:
                if x == y: return cnts
                if x < y: break
                tmp.add(x - y)
        toCheck = tmp
    return cnt