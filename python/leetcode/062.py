class Solution:
    def uniquePaths(self, m, n):
        if m == 1 or n == 1:
            return 1
        p = [[0 for i in range(n)] for j in range(m)]
        for i in range(1, n):
            p[0][i] = 1
        for i in range(1, m):
            p[i][0] = 1
        for i in range(1, m):
            for j in range(1, n):
                p[i][j] = p[i][j - 1] + p[i - 1][j]
        return p[m - 1][n - 1]
