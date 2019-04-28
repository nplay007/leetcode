class Solution(object):
    def numIslands2(self, m, n, positions):
        cnts, res, roots = 0, [], [-1] * (m * n)
        dp = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        for (x, y) in positions:
            idx = x * n + y
            roots[idx] = idx
            cnts += 1
            for (dx, dy) in dp:
                i, j = x + dx, y + dy
                pos = i * n + j
                if i >= 0 and i < m and j >= 0 and j < n and roots[pos] != -1:
                    rootIdx, rootPos = idx, pos
                    while rootIdx != roots[rootIdx]:
                        rootIdx = roots[rootIdx]
                    while rootPos != roots[rootPos]:
                        rootPos = roots[rootPos]
                    if rootIdx != rootPos:
                        roots[rootIdx] = rootPos
                        cnts -= 1
            res.append(cnts)
        return res
