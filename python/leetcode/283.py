class Solution(object):
    def moveZeroes(self, nums):
        j, i = 0, 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[i], nums[j] = nums[j], nums[i]
                j += 1
        return
