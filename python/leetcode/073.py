class Solution(object):
    def setZeroes(self, matrix):
        if not matrix: return
        m, n, col0 = len(matrix), len(matrix[0]), 1
        for i in range(m):
            if not matrix[i][0]: col0 = 0  # column 0
            for j in range(1, n):  # start from 1, 0 already check last step
                if not matrix[i][j]: matrix[i][0] = matrix[0][j] = 0
        for i in range(m - 1, -1, -1):
            for j in range(n - 1, 0, -1):
                if not matrix[i][0] or not matrix[0][j]: matrix[i][j] = 0
            if col0 == 0: matrix[i][0] = 0