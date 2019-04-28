class Solution:
    def maxDepth(self, root):
        if not root: return 0
        leftdepth = self.maxDepth(root.left)
        rightdepth = self.maxDepth(root.right)
        return leftdepth + 1 if leftdepth > rightdepth else rightdepth + 1