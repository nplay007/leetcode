class Solution(object):
    def maxSubArray(self, nums):
        if not nums:
            return 0;
        res, cur = nums[0], nums[0]
        for i in range(1, len(nums)):
            cur = max(nums[i], num[i] + cur)
            res = max(res, cur)
        return res