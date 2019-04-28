class Solution:
    def spiralOrder(self, matrix):
        if len(matrix) < 1: return []
        m, n = len(matrix), len(matrix[0])
        k, l = 0, 0
        res = []
        while k < m and l < n:
            for i in range(l, n): res.append(matrix[k][i])
            k += 1
            for i in range(k, m): res.append(matrix[i][n-1])
            n -= 1
            if k < m:
                for i in range(n-1, l-1, -1): res.append(matrix[m-1][i])
                m -= 1
            if l < n:
                for i in range(m-1, k-1, -1): res.append(matrix[i][l])
                l += 1
        return res
