class Solution:
    def numDistinct(self, S, T):
        m, n = len(S), len(T) 
        dp = [[0 for i in range(n + 1)] for j in range(m + 1)]
        for i in range(m + 1):
            dp[i][0] = 1
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                dp[i][j] = dp[i-1][j]
                if S[i-1] == T[j-1]:
                    dp[i][j] += dp[i-1][j-1]
        return dp[m][n]