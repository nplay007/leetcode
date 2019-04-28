class Solution:
    def minTotalDistance(self, grid):
        x = sorted([i for i, row in enumerate(grid) for v in row if v == 1]) # row number
        y = sorted([j for row in grid for j, v in enumerate(row) if v == 1]) # col number
        return sum(
            [abs(x[len(x) / 2] - i) + abs(y[len(y) / 2] - j) for i, row in enumerate(grid) for j, v in enumerate(row) if
             v == 1])