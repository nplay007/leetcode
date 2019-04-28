class NumMatrix(object):
    def __init__(self, matrix):
        if not matrix or not matrix[0]: return
        m, n = len(matrix), len(matrix[0])
        self.dp = [[0 for j in xrange(n + 1)] for i in xrange(m + 1)]
        for i in xrange(1, m + 1):
            for j in xrange(1, n + 1):
                self.dp[i][j] = matrix[i - 1][j - 1] + self.dp[i][j - 1] + \
                self.dp[i - 1][j] - self.dp[i - 1][j - 1]

    def sumRegion(self, row1, col1, row2, col2):
        row1, col1, row2, col2 = row1 + 1, col1 + 1, row2 + 1, col2 + 1
        return self.dp[row2][col2] - self.dp[row2][col1 - 1] - \
        self.dp[row1 - 1][col2] + self.dp[row1 - 1][col1 - 1]