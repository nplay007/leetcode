class Solution:
    def findLeaves(self, root):
        res = []
        self.helper(root, res)
        return res

    def helper(self, root, res):
        if not root:
            return -1
        depth = 1 + max(self.helper(root.left, res),
                        self.helper(root.right, res))
        if depth >= len(res):
            res.append([])
        res[depth].append(root.val)
        return depth


class Solution:
    def findLeaves(self, root):
        res = []
        while root:
            leaves = []
            root = self.remove(root, leaves)
            res.append(leaves)
        return res

    def remove(self, node, leaves):
        if not node:
            return None
        if not node.left and not node.right:
            leaves.append(node.val)
            return None
        node.left = self.remove(node.left, leaves)
        node.right = self.remove(node.right, leaves)
        return node
