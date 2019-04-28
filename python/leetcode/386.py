class Solution(object):
    def lexicalOrder(self, n):
        res = []
        for i in range(1, 10):
            self.dfs(i, n, res)
        return res

    def dfs(self, k, n, res):
            if k <= n:
                res.append(k)
                t = 10*k
                if t <= n:
                    for i in range(10):
                        self.dfs(t + i, res)
