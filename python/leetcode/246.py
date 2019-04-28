class Solution:
    def isStrobogrammatic(self, nums):
        dic = {"0": "0", "1": "1", "6": "9", "8": "8", "9": "6"}
        l, r = 0, len(nums) - 1
        while l <= r:
            if nums[l] not in dic or nums[l] != dic[nums[r]]: return False
            l += 1
            r -= 1
        return True