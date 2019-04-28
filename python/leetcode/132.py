class Solution(object):
    def minCut(self, s):
        if not s: return 0
        n = len(s)
        dp = [ i - 1 for i in range(n+1)]
        for i in range(1, n + 1):
            for j in range(i):
                if s[j:i] == s[j:i][::-1]:
                    dp[i] = min(dp[i], dp[j] + 1)
        return dp[n]