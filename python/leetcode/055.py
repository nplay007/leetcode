class Solution(object):
    def canJump(self, nums):
        reach = 0
        for i, num in enumerate(nums):
            if i > reach:
                return False
            reach = max(reach, i + num)
        return reach >= len(nums) - 1