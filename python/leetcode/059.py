class Solution(object):
    def generateMatrix(self, n):
        res = [[0] * n for i in range(n)]
        k, l, m = 0, 0, n
        cnts = 1
        while k < m and l < n:
            for i in range(l, n):
                res[k][i] = cnts
                cnts += 1
            k += 1
            for i in range(k, m):
                res[i][n - 1] = cnts  # n - 1
                cnts += 1
            n -= 1
            if k < m:  # k < m
                for i in range(n - 1, l - 1, -1):  # n - 1
                    res[m - 1][i] = cnts  # m - 1
                    cnts += 1
                m -= 1
            if l < n:  # l < n
                for i in range(m - 1, k - 1, -1):  # m - 1
                    res[i][l] = cnts
                    cnts += 1
                l += 1
        return res