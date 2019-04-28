class Solution(object):
    def twoSum(self, nums, target):
        if len(nums) < 2:
            raise ValueError("Invalid nums array")
        l, r = 0, len(nums) - 1
        while l < r:
            if nums[l] + nums[r] == target:
                return [l + 1, r + 1]
            elif nums[l] + nums[r] > target:
                r -= 1
            else:
                l += 1