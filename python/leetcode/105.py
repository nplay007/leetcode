class Solution:
    def buildTree(self, preorder, inorder):
        if not preorder or not inorder: return None
        root = TreeNode(preorder[0])
        idx = inorder.index(preorder[0])
        preorder.remove(preorder[0])
        root.left = self.buildTree(preorder, inorder[:idx])
        root.right = self.buildTree(preorder, inorder[idx+1:])
        return root