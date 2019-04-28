class Solution(object):
    def insertionSortList(self, head):
        if not head:
            return head
        dummy = ListNode(0)
        ptr, pre = head, dummy
        while ptr:
            tail = ptr.next
            while pre.next and pre.next.val < ptr.val:
                pre = pre.next
            ptr.next = pre.next
            pre.next = ptr
            pre = dummy
            ptr = tail
        return dummy.next