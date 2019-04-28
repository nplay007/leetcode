class Solution:
    def isMatch(self, s, p):
        m, n = len(s), len(p)
        dp = [[False for i in range(n + 1)] for j in range(m + 1)]
        dp[0][0] = True
        for i in range(1, n + 1):
            dp[0][i] = i > 1 and '*' == p[i - 1] and dp[0][i - 2]
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if p[j - 1] != '*':
                    dp[i][j] = dp[i - 1][j - 1] and (s[i - 1] == p[j - 1] or '.' == p[j - 1])
                else:
                    dp[i][j] = dp[i][j - 2] or (dp[i - 1][j] and (s[i - 1] == p[j - 2] or p[j - 2] == '.'))
        return dp[m][n]
