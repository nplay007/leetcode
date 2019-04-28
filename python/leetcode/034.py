class Solution:
    def searchRange(self, nums, target):
        res = [-1, -1]
        if not nums:
            return res
        l, r = 0, len(nums) - 1
        while l < r:
            m = l + (r - l) / 2
            if nums[m] < target:
                l = m + 1
            else:
                r = m
        if nums[r] != target:
            return res
        res[0] = r
        r = len(nums)
        while l < r:
            m = l + (r - l) / 2
            if nums[m] <= target:
                l = m + 1
            else:
                r = m
        res[1] = l - 1  # numss[l] != target
        return res
