class Solution:
    def countNodes(self, root):
        if not root: return 0
        ll, lr = root, root
        hl, hr = 0, 0
        while ll:
            hl += 1
            ll = ll.left
        while lr:
            hr += 1
            lr = lr.right
        if hl == hr: return 2**hl - 1
        return 1 + self.countNodes(root.left) + self.countNodes(root.right)