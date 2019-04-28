class Solution(object):
    def generateParenthesis(self, n):
        res = []
        self.dfs(n, n, "", res)
        return res

    def dfs(self, l, r, ans, res):
        if l == 0 and r == 0:
            res.append(ans)
        if l > 0 and l <= r:
            self.dfs(l - 1, r, ans + '(', res)
        if r > 0 and l <= r:
            self.dfs(l, r - 1, ans + ')', res)