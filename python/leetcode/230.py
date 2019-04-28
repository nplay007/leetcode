class Solution:
    def kthSmallest(self, root, k):
        self.k = k
        self.res = None
        self.help(root)
        return self.res

    def help(self, node):
        if not node: return
        self.helper(node.left)
        self.k -= 1
        if self.k == 0:
            self.res = node.val
            return
        self.helper(node.right)


def kthSmallest(root, k):
    stack = []
    while root or stack:
        while root:
            stack.append(root)
            root = root.left
        root = stack.pop()
        k -= 1
        if k == 0: return root.val
        root = root.right