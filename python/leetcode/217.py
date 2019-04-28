class Solution:
    def containsDuplicate(self, nums):
        result = {}
        for item in nums:
            result[item] = result.get(item, 0) + 1
        for val in result.itervalues():
            if val > 1: return True
        return False

    def containsDuplicate(self, nums):
        return len(nums) == len(set(nums))