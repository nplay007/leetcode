class Solution(object):
    def majorityElement(self, nums):
        cnts, res = 0, 0
        for num in nums:
            if cnts == 0:
                res = num
                cnts = 1
            else:
                cnts += 1 if res == num else -1
        return res
