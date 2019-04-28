class Solution(object):
    def findMin(self, nums):
        l, r = 0, len(nums) - 1
        while l < r: # not equal
            mid = (r - l) / 2 + l
            if nums[mid] <= nums[r]: r = mid
            else: l = mid + 1
        return nums[l]
