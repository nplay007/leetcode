class Solution:
    def upsideDownBinaryTree(self, root):
        if not root or not root.left:
            return root
        left = root.left
        right = root.right
        nroot = self.upsideDownBinaryTree(left)
        left.right = root
        left.left = right
        root.left = None
        root.right = None
        return nroot
