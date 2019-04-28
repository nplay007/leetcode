class Solution:
    def reverseBetween(self, head, m, n):
        if not head or not head.next: return head
        dummy = ListNode(0)
        dummy.next, ptr = head, dummy
        for i in range(m - 1): ptr = ptr.next
        start, end = ptr.next, ptr.next.next
        for i in range(n - m):  # reverse a pair node each time
            start.next = end.next
            end.next = ptr.next
            ptr.next = end
            end = start.next
        return dummy.next