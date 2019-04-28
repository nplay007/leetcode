class Solution:
    def connect(self, root):
        if root and root.left:
            root.left.next = root.right
            if root.next:
                root.right.next = root.next.left
            else:
                root.right.next = None
            self.connect(root.left)
            self.connect(root.right)


class Solution:
    def connect(self, root):
        if not root:
            return root
        ptr, cur = root, None
        while ptr.left:
            cur = ptr
            while cur:
                cur.left.next = cur.right
                if cur.next:
                    cur.right.next = cur.next.left
                cur = cur.next
            ptr = ptr.left