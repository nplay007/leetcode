class Solution:
    def countUnivalSubtrees(self, root):
        self.count = 0
        self.unival(root)
        return self.count

    def unival(self, root):
        if not root: return True
        l = self.unival(root.left)
        r = self.unival(root.right)
        if l and r and (not root.left or root.left.val == root.val) and (not root.right or root.right.val == root.val):
            self.count += 1
            return True
        return False