class Solution:
    def maxsum(self, root):
        if not root: return 0
        left = max(0, self.maxsum(root.left))
        right = max(0, self.maxsum(root.right))
        Solution.max = max(Solution.max, left + right + root.val)
        return max(left, right) + root.val

    def maxPathSum(self, root):
        Solution.max = -float("Infinity")
        self.maxsum(root)
        return Solution.max