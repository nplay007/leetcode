class Solution(object):
    def maxProduct(self, nums):
        if not nums:
            return 0
        vmax, vmin, res = nums[0], nums[0], nums[0]
        for i in range(1, len(nums)):
            if nums[i] < 0:
                vmax, vmin = vmin, vmax
            vmax = max(nums[i], nums[i] * vmax)
            vmin = min(nums[i], nums[i] * vmin)
            res = max(res, vmax)
        return res
