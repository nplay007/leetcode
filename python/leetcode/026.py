class Solution:
    def removeDuplicates(self, nums):
        if not nums:
            return 0
        j = 0
        for i in range(len(nums)):
            if nums[j] != nums[i]:
                nums[j + 1] = nums[i]
                j += 1
        return j + 1
