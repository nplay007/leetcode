class Solution:
    def iterativer(self, root):
        stack, res = [], []
        while root or stack:
            if root:
                stack.append(root)
                root = root.left
            else:
                root = stack.pop()
                res.append(root.val)
                root = root.right
        return res
                
    def recursive(self, root, res):
        if not root: return 
        self.recursive_in_order(root.left, res)
        res.append(root.val)
        self.recursive_in_order(root.right, res)

    def inorderTraversal(self, root):
        res = []
        self.iterative_inorder(root, res)
        return res


def inorder(root):
    cur, pre, res = root, None, []
    while cur:
        if not cur.left:
            res.append(cur.val)
            cur = cur.right
        else:
            pre = cur.left
            while pre.right and pre.right != cur:
                pre = pre.right
            if not pre.right:
                pre.right = cur
                cur = cur.left
            else:
                pre.right = None
                res.append(cur.val)
                cur = cur.right 