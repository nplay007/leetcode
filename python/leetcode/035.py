class Solution:
    def searchInsert(self, num, target):
        l, r = 0, len(num) - 1
        while l <= r:
            m = (r - l) / 2 + l
            if num[m] == target:
                return m
            if num[m] > target:
                r = m - 1
            else:
                l = m + 1
        return l
