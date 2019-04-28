class Solution:
    def largestBSTSubtree(self, root):
        res = 0
        self.dfs(root, res)
        return res

    def dfs(self, root, res):
        if not root: return
        d = self.countBFS(root, -float("Inf"), float("Inf"))
        if d != -1: # the root is bst with left and right node
            res = max(res, d)
            return
        self.dfs(root.left, res)
        self.dfs(root.right, res)

    def countBFS(self, root, mn, mx):
        if not root: return 0
        if root.val < mn or root.val > mx: return -1
        left = self.countBFS(root.left, mn, root.val)
        if left == -1: return -1
        right = self.countBFS(root.right, root.val, mx)
        if right == -1: return -1
        return left + right + 1