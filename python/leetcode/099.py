class Solution(object):
    def recoverTree(self, root):
        if not root:
            return
        self.first, self.second = None, None
        self.pre = TreeNode(-2**31)
        self.help(root)
        self.first.val, self.second.val = self.second.val, self.first.val

    def help(self, root):
        if not root:
            return
        self.help(root.left)
        if not self.first and self.pre.val >= root.val:
            self.first = self.pre
        if self.first and self.pre.val >= root.val:
            self.second = root
        self.pre = root
        self.help(root.right)
