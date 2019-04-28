class Solution:
    def numberOfPatterns(self, m, n):
        return self.count(m, n, 0, 1, 1)

    def count(self, m, n, used, i1, j1):
        res = m <= 0
        if not n: return 1
        for i in range(3):
            for j in range(3):
                I = i1 + i
                J = j1 + j
                used2 = used | (1 << (i * 3 + j))
                if used2 > used and (I % 2 or J % 2 or used2 & (1 << (I / 2 * 3 + J / 2))):
                    res += self.count(m - 1, n - 1, used2, i, j)
        return res
