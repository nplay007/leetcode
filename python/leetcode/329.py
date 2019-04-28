class Solution:
    def longestIncreasingPath(self, matrix):
        if not matrix or not matrix[0]: return 0
        M, N = len(matrix), len(matrix[0])
        dp = [[0] * N for i in range(M)]
        return max(self.dfs(x, y, dp, M, N, matrix) for x in range(M) for y in range(N))

    def dfs(self, i, j, dp, M, N, matrix):
        if not dp[i][j]:
            val = matrix[i][j]
            dp[i][j] = 1 + max(
                self.dfs(i - 1, j) if i and val > matrix[i - 1][j] else 0,
                self.dfs(i + 1, j) if i < M - 1 and val > matrix[i + 1][j] else 0,
                self.dfs(i, j - 1) if j and val > matrix[i][j - 1] else 0,
                self.dfs(i, j + 1) if j < N - 1 and val > matrix[i][j + 1] else 0)
        return dp[i][j]
