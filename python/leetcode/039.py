class Solution(object):
    def combinationSum(self, candidates, target):
        candidates.sort()
        res = []
        self.dfs(0, target, candidates, [], res)
        return res

    def dfs(self, start, target, nums, ans, res):
        if target == 0:
            res.append(ans)
            return
        for i in range(start, len(nums)):
            if target < nums[i]: return
            self.dfs(i, target - nums[i], nums, ans+[nums[i]], res)