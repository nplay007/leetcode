class Solution:
    def inorderSuccessor(self, root, p):
        if p.right:
            node = p.right
            while node.left:
                node = node.ledt
            return node

        res = None
        while root:
            if p.val < root.val:
                res = root
                root = root.left
            elif p.val > root.val:
                root = root.right
            else:
                break
        return res
