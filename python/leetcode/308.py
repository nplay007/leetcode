class BinaryIndexedTree(object):
    def __init__(self, matrix):
        m, n = len(matrix), len(matrix[0]) if matrix else 0

        self.matrix = matrix
        self.sums = [[0] * (n + 1) for _ in xrange(m + 1)]

        [operator.setitem(
            self.sums[row], col,
            self.sums[row][col] + self.matrix[i - 1][j - 1]
        )
        for row in xrange(1, len(self.sums))
        for col in xrange(1, len(self.sums[0]))
        for i in xrange(row + 1 - (row & -row), row + 1)
        for j in xrange(col + 1 - (col & -col), col + 1)]

    def update(self, row, col, val):
        i = row + 1
        while i < len(self.sums):
            j = col + 1
            while j < len(self.sums[0]):
                self.sums[i][j] += val - self.matrix[row][col]
                j += j & -j
            i += i & -i
        self.matrix[row][col] = val

    def sum(self, row, col):
        r, i = 0, row
        while i > 0:
            j = col
            while j > 0:
                r += self.sums[i][j]
                j -= j & -j
            i -= i & -i
        return r


class NumMatrix(object):
    def __init__(self, matrix):
        self.tree = BinaryIndexedTree(matrix)

    def update(self, row, col, val):
        self.tree.update(row, col, val)

    def sumRegion(self, row1, col1, row2, col2):
        return (
            self.tree.sum(row2 + 1, col2 + 1) +
            self.tree.sum(row1, col1) -
            self.tree.sum(row1, col2 + 1) -
            self.tree.sum(row2 + 1, col1))