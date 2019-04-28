class Solution(object):
    def threeSumClosest(self, nums, target):
        if len(nums) < 3:
            raise ValueError("Invalid nums array")
        absThreeSum, minThreeSum = 2**31 - 1, 0
        nums.sort()
        for i in range(len(nums) - 2):
            if i > 0 and nums[i - 1] == nums[i]:
                continue
            left, right = i + 1, len(nums) - 1
            while left < right:
                threeSum = nums[i] + nums[left] + nums[right]
                if abs(threeSum - target) < absThreeSum:
                    absThreeSum = abs(threeSum - target)
                    minThreeSum = threeSum
                if threeSum == target:
                    return minThreeSum
                elif threeSum > target:
                    right -= 1
                else:
                    left += 1
        return minThreeSum
