class Solution(object):
    def sortedListToBST(self, head):
        if not head: return
        if not head.next: return TreeNode(head.val)
        slow, fast = head, head.next
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
        tmp = slow.next # tmp points to root
        # cut down the left child
        slow.next = None
        root = TreeNode(tmp.val)
        root.left = self.sortedListToBST(head)
        root.right = self.sortedListToBST(tmp.next)
        return root
