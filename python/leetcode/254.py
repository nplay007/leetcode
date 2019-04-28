class Solution(object):
    def getFactors(self, n):
        res = []
        self.help(n, 2, [], res)
        return res

    def help(self, n, i, ans, res):
        while i*i <= n:
            if n % i == 0:
                res.append(ans + [i, n/i])
                self.help(n/i, i, ans + [i], res)
            i += 1