class Solution(object):
    def maxArea(self, height):
        res, left, right = 0, 0, len(height) - 1
        while left < right:
            res = max(res, (right - left) * min(height[left], height[right]))
            if height[left] < height[right]:
                left += 1
            else :
                right -= 1
        return res
