class Solution(object):
    def subsetsWithDup(self, nums):
        nums.sort()
        res, ans  = [], []
        for i in range(len(nums)+1):
            self.dfs(nums, 0, i,  ans, res)
        return res

    def dfs(self, nums, start, n, ans, res):
        if len(ans) == n:
            res.append(ans)
            return
        for i in range(start, len(nums)):
            if i != start and nums[i] == nums[i-1]: continue
            self.dfs(nums, i+1, n,  ans + [nums[i]], res)