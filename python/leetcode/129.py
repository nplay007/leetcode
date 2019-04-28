class Solution:
    def search(self, root, s):
        if not root: return 0
        if not root.left and not root.right:
            return s*10 + root.val
        return self.search(root.left, s*10 + root.val) + self.search(root.right, s*10 + root.val)

    def sumNumbers(self, root):
        return self.search(root, 0)