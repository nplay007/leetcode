class Solution(object):
    def missingNumber(self, nums):
        res = len(nums)
        for i, item in enumerate(nums):
            res ^= item
            res ^= i
        return res 