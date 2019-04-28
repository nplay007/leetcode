class Solution:
    def largestRectangleArea(self, height):
        stack, i, res = [], 0, 0
        h = height + [0]
        while i < len(h):
            if not stack or h[stack[-1]] <= h[i]:
                stack.append(i)
                i += 1
            else:
                t = stack.pop()
                res = max(res, h[t] * (i if not stack else i - stack[-1] - 1))
        return res