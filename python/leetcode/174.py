class Solution(object):
    def calculateMinimumHP(self, dungeon):
        m, n, INT_MAX = len(dungeon), len(dungeon[0]), 2**31 - 1
        dp = [[INT_MAX] * (n+1) for j in range(m+1)]
        dp[m][n-1], dp[m-1][n] = 1, 1 
        for i in range(m-1, -1, -1):
            for j in range(n-1, -1, -1):
                dp[i][j] = max(1, min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j])
        return dp[0][0]