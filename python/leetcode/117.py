class Solution:
    def connect(self, root):
        cur = root
        while cur:
            pre, ptr = None, None
            while cur:
                if not pre:
                    pre = cur.left if cur.left else cur.right
                if cur.left:
                    if ptr: ptr.next = cur.left
                    ptr = cur.left
                if cur.right:
                    if ptr: ptr.next = cur.right
                    ptr = cur.right
                cur = cur.next
            cur = pre