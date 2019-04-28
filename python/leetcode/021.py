class Solution(object):
    def mergeTwoLists(self, l1, l2):
        head = ListNode(0)
        ptr = head
        while l1 and l2:
            if l1.val > l2.val:
                ptr.next = l2
                l2 = l2.next
            else:
                ptr.next = l1
                l1 = l1.next
            ptr = ptr.next
        ptr.next = l1 if l1 else l2
        return head.next


class Solution(object):
    def mergeTwoLists(self, l1, l2):
        if not l1 or not l2:
            return l1 if l1 else l2
        ptr = None
        if l1.val < l2.val:
            ptr = l1
            ptr.next = self.mergeTwoLists(l1.next, l2)
        else:
            ptr = l2
            ptr.next = self.mergeTwoLists(l1, l2.next)
        return ptr
