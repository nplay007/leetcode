class Solution:
    def subsets(self, s):
        if not s: return []
        s.sort()
        res = []
        for i in range(len(s)+1):
            self.comb(s, 0, i, [], res)
        return res

    def comb(self, s, start, n, ans, res):
        if len(ans) == n:
            res.append(ans)
            return 
        for i in range(start, len(s)):
            self.comb(s, i+1, n,  ans + [s[i]], res)

class Solution(object):
    def subsets(self, nums):
        nums.sort()
        n = len(nums)
        ans = 2 ** n
        res = [[] for i in xrange(ans)]
        for i in xrange(n):
            for j in range(ans):
                if (j >> i) & 1:
                    res[j].append(nums[i])
        return res