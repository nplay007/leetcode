class Solution:
    def maximalSquare(self, matrix):
        if not matrix: return 0
        m, n = len(matrix), len(matrix[0])
        dp = [[0] * n for x in range(m)]
        ans = 0
        for x in range(m):
            for y in range(n):
                dp[x][y] = int(matrix[x][y])
                if x and y and dp[x][y]:
                    dp[x][y] = min(dp[x - 1][y - 1], dp[x][y - 1], dp[x - 1][y]) + 1
                ans = max(ans, dp[x][y])
        return ans * ans


class Solution:
    def maximalSquare(self, matrix):
        m = len(matrix)
        n = len(matrix[0]) if m > 0 else 0
        dp = [0 for i in range(n+1)]
        ans, prev = 0, 0
        for i in range(1, m+1):
            for j in range(1, n+1):
                temp = dp[j]
                if matrix[i - 1][j - 1] == '1':
                    dp[j] = min(dp[j - 1], prev, dp[j]) + 1
                    ans = max(ans, dp[j])
                else:
                    dp[j] = 0
                prev = temp
        return ans * ans