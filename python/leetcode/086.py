class Solution:
    def partition(self, head, x):
        dummy1, dummy2 = ListNode(0), ListNode(0)
        l1, l2 = dummy1, dummy2
        while head:
            if head.val < x:
                l1.next = head
                l1 = l1.next
            else:
                l2.next = head
                l2 = l2.next
            head = head.next
        l2.next = None
        l1.next = dummy2.next
        return dummy1.next
