class Solution:
    def productExceptSelf(self, nums):
        res = [0] * len(nums)
        res[0], factor = 1, 1
        for i in range(1,len(nums)):
            res[i] = res[i-1] * nums[i-1]
        for i in range(len(nums)-1, -1, -1):
            res[i] *= factor
            factor *= nums[i]
        return res 