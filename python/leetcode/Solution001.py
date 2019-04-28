class Solution(object):
    def twoSum(self, nums, target):
        sums = {}
        for idx, num in enumerate(nums):
            if target - num in sums:
                return [sums[target - num], idx]
            sums[num] = idx
        raise ValueError("Can't find answer for the input")
