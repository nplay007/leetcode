class Solution(object):
    def trapRainWater(self, heightMap):
        m = len(heightMap)
        if m == 0:
            return 0
        n = len(heightMap[0])
        if n == 0:
            return 0
        visited = [[False for i in range(n)] for j in range(m)]
        from Queue import PriorityQueue
        q = PriorityQueue()
        for i in range(m):
            visited[i][0] = True
            q.put([heightMap[i][0],i,0])
            visited[i][n-1] = True
            q.put([heightMap[i][n-1],i,n-1])
        for j in range(1, n-1):
            visited[0][j] = True
            q.put([heightMap[0][j],0,j])
            visited[m-1][j] = True
            q.put([heightMap[m-1][j],m-1,j])
        S = 0
        while not q.empty():
            cell = q.get()
            for (i, j) in [(1,0), (-1,0), (0,1), (0,-1)]:
                x = cell[1] + i
                y = cell[2] + j
                if x in range(m) and y in range(n) and not visited[x][y]:
                    S += max(0, cell[0] - heightMap[x][y])   # how much water at the cell
                    q.put([max(heightMap[x][y],cell[0]),x,y])
                    visited[x][y] = True
        return S