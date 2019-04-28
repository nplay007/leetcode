class Solution:
    def findMin(self, num):
        left, right = 0, len(num) - 1
        while left < right :
            m = left + (right - left)/2
            if num[m] > num[right]: left = m + 1
            elif num[m] < num[right]: right = m
            else: right -= 1
        return num[left]
