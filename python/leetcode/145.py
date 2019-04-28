class Solution:
    def recursive_postorder(self, root, res):
        if not root: return 
        self.postorder(root.left, res)
        self.postorder(root.right, res)
        res.append(root.val)

    def postorderTraversal(self, root):
        res = []
        self.iterative_postorder(root, res)
        return res