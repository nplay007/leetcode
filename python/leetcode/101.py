class Solution:
    def Mirror(self, left, right):
        if not left or not right:
            return left == right
        if left.val == right.val:
            return self.Mirror(left.right, right.left) self.Mirror(left.left, right.right)
        else: return False

    def isSymmetric(self, root):
        return self.Mirror(root, root)