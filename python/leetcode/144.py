class Solution:
    def help(self, root, res):
        if not root: return
        res.append(root.val)
        self.help(root.left, res)
        self.help(root.right, res)

    def preorderTraversal(self,root):
        res = []
        self.help(root, res)
        return res


class Solution(object):
    def preorderTraversal(self, root):
        res, stack = [], []
        while root or stack:
            if root:
                res.append(root.val)
                stack.append(root)
                root = root.left
            else:
                root = stack.pop()
                root = root.right
        return res
