class Solution:
    def firstMissingPositive(self, nums):
        n = len(nums)
        for i in xrange(n):
            while (nums[i] > 0) and (nums[i] <= n) and (nums[i] != nums[nums[i] - 1]):
                nums[nums[i] - 1], nums[i] = nums[i], nums[nums[i] - 1]
        for i in xrange(n):
            if nums[i] != i + 1:
                return i + 1
        return n + 1
