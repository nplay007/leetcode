class Solution(object):
    def oddEvenList(self, head):
        if not head or not head.next: return head
        h1, h2 = ListNode(0), ListNode(0)
        odd, even = h1, h2
        while head:
            odd.next = head
            even.next = head.next
            odd = odd.next
            even = even.next
            head = head.next.next if even else None
        odd.next = h2.next
        return h1.next
