class Solution(object):
    def combinationSum2(self, nums, target):
        nums.sort()
        res = []
        self.dfs(0, target, nums, [], res)
        return res

    def dfs(self, start, target, nums, ans, res):
        if target == 0:
            res.append(ans)
            return
        for i in range(start, len(nums)):
            if target < nums[i]: return
            if i == start or nums[i] != nums[i-1]:
                self.dfs(i+1, target - nums[i], nums, ans + [nums[i]], res)