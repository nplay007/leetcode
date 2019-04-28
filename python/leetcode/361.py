class Solution(object):
    def maxKilledEnemies(self, grid):
        if not grid or not grid[0]:
            return 0
        m, n = len(grid), len(grid[0])
        res, rowCnt, colCnt = 0, 0, [0] * n
        for i in range(m):
            for j in range(n):
                if j == 0 or grid[i][j - 1] == 'W':
                    rowCnt, k = 0, j
                    while k < n and grid[i][k] != 'W':
                        rowCnt += grid[i][k] == 'E'
                        k += 1
                if i == 0 or grid[i - 1][j] == 'W':
                    colCnt[j], k = 0, i
                    while k < m and grid[k][j] != 'W':
                        colCnt[j] += grid[k][j] == 'E'
                        k += 1
                if grid[i][j] == '0':
                    res = max(res, rowCnt + colCnt[j])
        return res
