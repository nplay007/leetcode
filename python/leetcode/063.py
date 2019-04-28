class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid):
        if not obstacleGrid or not obstacleGrid[0]: return 0
        m, n = len(obstacleGrid), len(obstacleGrid[0])
        p = [[0 for i in range(n)] for j in range(m)]
        for i in range(n):
            if obstacleGrid[0][i] == 0: p[0][i] = 1
            else:
                p[0][i] = 0
                break
        for i in range(m):
            if obstacleGrid[i][0] == 0: p[i][0] = 1
            else:
                p[i][0] = 0
                break
        for i in range(1,m):
            for j in range(1,n):
                if obstacleGrid[i][j] == 1: p[i][j] = 0
                else: p[i][j] = p[i][j-1] + p[i-1][j]
        return p[m-1][n-1]