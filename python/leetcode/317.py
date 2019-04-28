class Solution:
    def shortestDistance(self, grid):
        if not grid or not grid[0]: return -1
        M, N = len(grid), len(grid[0])
        buildings = sum(val for line in grid for val in line if val == 1)
        hit = [[0] * N for i in range(M)]
        distSum = [[0] * N for i in range(M)]

        def BFS(x, y):
            visited = [[False] * N for k in range(M)]
            visited[x][y], cnts, queue = True, 1, collections.deque([(x, y, 0)])
            while queue:
                x, y, dist = queue.popleft()
                for i, j in ((x + 1, y), (x - 1, y), (x, y + 1), (x, y - 1)):
                    if 0 <= i < M and 0 <= j < N and not visited[i][j]:
                        visited[i][j] = True
                        if not grid[i][j]:
                            queue.append((i, j, dist + 1))
                            hit[i][j] += 1
                            distSum[i][j] += dist + 1
                        elif grid[i][j] == 1: cnts += 1
            return cnts == buildings

        for x in range(M):
            for y in range(N):
                if grid[x][y] == 1:
                    if not BFS(x, y): return -1
        return min([distSum[i][j] for i in range(M) for j in range(N) if not grid[i][j] and hit[i][j] == buildings] or [-1])