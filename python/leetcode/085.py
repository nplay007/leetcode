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

    def maximalRectangle(self, matrix):
        if not matrix: return 0
        dp = [0 for i in range(len(matrix[0]))]
        maxArea = 0
        for i in range(len(matrix)):
            for j in range(len(matrix[i])):
                dp[j] = dp[j] + 1 if matrix[i][j] == '1' else 0
            maxArea = max(maxArea, self.largestRectangleArea(dp))
        return maxArea