class Solution(object):
    def combinationSum3(self, k, n):
        if k == 0: return []
        res = []
        self.help(k, n, 0, 0, [], res)
        return res
    
    def help(self, k, n, start, tmp, ans, res):
        if len(ans) > k or tmp > n:
            return 
        if len(ans) == k and tmp == n:
            res.append(ans)
            return
        for i in range(start + 1, 10):
            self.help(k, n, i, tmp + i, ans + [i], res)