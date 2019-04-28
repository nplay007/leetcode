class Solution:
    def largestNumber(self, nums):
        strs = [str(x) for x in nums]
        strs.sort(cmp=lambda x, y: cmp(y + x, x + y))
        return ''.join(strs)).lstrip('0') or '0'
