class Solution(object):
    def findMissingRanges(self, nums, lower, upper):
        res = []
        nums.append(upper+1)
        l = lower - 1
        for num in nums:
            if num == l + 2:
                res.append(str(num - 1))
            elif num > l + 2:
                res.append(str(l + 1) + "->" + str(num - 1))
            l = num
        return res