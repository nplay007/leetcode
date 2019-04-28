class Solution(object):
    def reverseKGroup(self, head, k):
        if not head or k == 1:
            return head
        dummy = ListNode(0)
        dummy.next, ptr, n = head, dummy, 0
        while ptr.next:
            n += 1
            ptr = ptr.next
        pre = dummy
        while n >= k:
            ptr = pre.next
            for i in range(1, k):
                tmp = ptr.next
                ptr.next = tmp.next
                tmp.next = pre.next
                pre.next = tmp
            pre = ptr
            n -= k
        return dummy.next