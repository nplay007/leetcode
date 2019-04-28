class Solution:
    def combine(self, n, k):
        res = []
        self.dfs(0, k, n, [], res)
        return res
 
    def dfs(self, start, k, n, ans, res):
        if len(ans) == k:
            res.append(ans)
            return 
        for i in xrange(start, n)):
            self.dfs(i + 1, k, n, ans + [nums[i]], res)