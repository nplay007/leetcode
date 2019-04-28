class Solution:
    def numIslands(self, grid):
        ans = 0
        if not len(grid):
            return ans
        m, n = len(grid), len(grid[0])
        visited = [[False] * n for i in range(m)]
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1' and not visited[i][j]:
                    ans += 1
                    self.bfs(grid, visited, i, j, m, n)
        return ans

    def bfs(self, grid, visited, i, j, m, n):
        dz = zip([1, 0, -1, 0], [0, 1, 0, -1])
        queue = [(i, j)]
        visited[i][j] = True
        while queue:
            front = queue.pop(0)
            for p in dz:
                np = (front[0] + p[0], front[1] + p[1])
                if self.isValid(np, m, n) and grid[np[0]][np[1]] == '1' and not visited[np[0]][np[1]]:
                    visited[np[0]][np[1]] = True
                    queue.append(np)

    def isValid(self, np, m, n):
        return 0 <= np[0] < m and 0 <= np[1] < n


class Solution(object):
    def numIslands(self, grid):
        ans = 0
        m, n = len(grid), len(grid[0])
        check = [[False for i in xrange(n)] for j in xrange(m)]
        for i in xrange(m):
            for j in xrange(n):
                if not check[i][j] and grid[i][j] == '1':
                    self.dfs(grid, check, i, j, m, n)
                    ans += 1
        return ans

    def dfs(self, grid, check, i, j, m, n):
        check[i][j] = True
        if i > 0 and not check[i - 1][j] and grid[i - 1][j] == '1':
            self.dfs(grid, check, i - 1, j, m, n)
        if i < m - 1 and not check[i + 1][j] and grid[i + 1][j] == '1':
            self.dfs(grid, check, i + 1, j, m, n)
        if j > 0 and not check[i][j - 1] and grid[i][j - 1] == '1':
            self.dfs(grid, check, i, j - 1, m, n)
        if j < n - 1 and not check[i][j + 1] and grid[i][j + 1] == '1':
            self.dfs(grid, check, i, j + 1, m, n)
