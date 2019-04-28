class Solution(object):
    def threeSum(self, nums):
        res = []
        if len(nums) < 3:
            return res
        nums.sort()
        for i in range(len(nums) - 2):
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            left, right = i + 1, len(nums) - 1
            while left < right:
                threeSum = nums[i] + nums[left] + nums[right]
                if threeSum == 0:
                    res.append([nums[i], nums[left], nums[right]])
                    while left < right and nums[left] == nums[left + 1]:
                        left += 1
                    while left < right and nums[right] == nums[right - 1]:
                        right -= 1
                    left, right = left - 1, right - 1
                elif threeSum < 0:
                    left += 1
                else:
                    right -= 1
        return res
