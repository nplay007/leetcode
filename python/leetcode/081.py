class Solution:
    def search(self, nums, target):
        l, r = 0, len(nums) - 1
        while l <= r:
            m = (r - l)/2 + l
            if nums[m] == target: return True
            if nums[m] > nums[l]:
                if nums[l] <= target < nums[m]: r = m - 1
                else: l = m + 1
            elif nums[m] < nums[l]:
                if nums[m] < target <= nums[r]: l = m + 1
                else: r = m - 1
            else:  l += 1
        return False