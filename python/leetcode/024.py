class Solution(object):
    def swapPairs(self, head):
        dummy = ListNode(0)
        dummy.next, ptr = head, dummy
        while ptr.next and ptr.next.next:
            tmp = ptr.next.next
            ptr.next.next = tmp.next
            tmp.next = ptr.next
            ptr.next = tmp
            ptr = ptr.next.next
        return dummy.next
