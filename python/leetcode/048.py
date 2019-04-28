class Solution(object):
    def rotate(self, matrix):
        m, n = len(matrix), len(matrix[0])
        matrix.reverse()
        for i in range(m):
            for j in range(i):
                matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]