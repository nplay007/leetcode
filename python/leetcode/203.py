class Solution:
    def removeElements(self, head, val):
        if not head:
            return head
        dummy = ListNode(0)
        ptr, dummy.next = dummy, head
        while ptr.next:
            if ptr.next.val == val:
                ptr.next = ptr.next.next
            else:
                ptr = ptr.next
        return dummy.next
