class Solution:
    def rightView(self, root, res, depth):
        if not root:
            return
        if depth == len(res):
            res.append(root.val)
        self.rightView(root.right, res, depth + 1)
        self.rightView(root.left, res, depth + 1)

    def rightSideView(self, root):
        result = []
        self.rightView(root, result, 0)
        return result
