class Solution:
    def plusOne(self, head):
        tail = None
        while head:
            head.next, head, tail = tail, head.next, head
        carry = 1
        while tail:
            carry, tail.val = divmod(carry + tail.val, 10)
            if carry and not tail.next:
                tail.next = ListNode(carry)
            tail.next, tail, head = head, tail.next, tail
        return head
