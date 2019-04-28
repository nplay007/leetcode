class Solution(object):
    def summaryRanges(self, nums):
        res, i = [], 0 
        if len(nums) == 1: return [str(nums[0])]
        while i < len(nums):
            start = nums[i]
            while i + 1 < len(nums) and nums[i] == nums[i+1] - 1: i += 1
            if start != nums[i]:
                res.append(str(start) + "->" + str(nums[i]))
            else:
                res.append(str(start))
            i += 1
        return res