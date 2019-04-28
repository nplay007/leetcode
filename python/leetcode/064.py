class Solution:
    def minPathSum(self, grid):
        if not grid or not grid[0]:
            return 0
        m, n = len(grid), len(grid[0])
        p = [[0 for i in range(n)] for j in range(m)]
        p[0][0] = grid[0][0]
        for i in range(1, m):
            p[i][0] = p[i - 1][0] + grid[i][0]
        for j in range(1, n):
            p[0][j] = p[0][j - 1] + grid[0][j]
        for i in range(1, m):
            for j in range(1, n):
                p[i][j] = min(p[i - 1][j], p[i][j - 1]) + grid[i][j]
        return p[m - 1][n - 1]
