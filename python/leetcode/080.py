class Solution:
    def removeDuplicates(self, nums):
        n = len(nums)
        if n <= 2:
            return n
        j = 2
        for i in xrange(2, n):
            if nums[i] != nums[j - 2]:
                nums[j] = nums[i]
                j += 1
        return j
