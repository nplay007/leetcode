from data import ListNode

class Solution002(object):
    def addTwoNumbers(self, l1, l2):
        if not l1 or not l2:
            return l1 if l1 else l2
        dummy = ListNode(0);
        ptr, carry = dummy, 0
        while l1 or l2 or carry:
            val1 = l1.val if l1 else 0
            val2 = l2.val if l2 else 0
            sums = val1 + val2 + carry
            ptr.next = ListNode(sums % 10)
            ptr = ptr.next
            carry = sums / 10
            l1 = l1.next if l1 else None
            l2 = l2.next if l2 else None
        return dummy.next