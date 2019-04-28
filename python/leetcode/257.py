class Solution:
    def binaryTreePaths(self, root):
        res = []
        self.dfs(root, "", res)
        return res

    def dfs(self, root, ans, res):
        if not root: return 
        if not root.left and not root.right:
            res.append(ans + str(root.val))
            return
        if root.left:
            self.dfs(root.left, ans + str(root.val) + "->", res)
        if root.right:
            self.dfs(root.right, ans + str(root.val) + "->", res)