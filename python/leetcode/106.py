class Solution:
    def buildTree(self, inorder, postorder):
        if not inorder or not postorder: return None
        root = TreeNode(postorder.pop())
        idx = inorder.index(root.val)
        root.right = self.buildTree(inorder[idx+1:], postorder)
        root.left = self.buildTree(inorder[:idx], postorder)
        return root