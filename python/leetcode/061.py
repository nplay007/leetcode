class Solution(object):
    def rotateRight(self, head, k):
        if not head or not head.next or k == 0:
            return head
        n, slow = 0, head
        while slow:
            n += 1
            slow = slow.next
        if k % n == 0:
            return head
        k %= n
        slow, fast = head, head
        for i in range(k):
            fast = fast.next
        while fast.next:
            slow = slow.next
            fast = fast.next
        fast.next = head
        head = slow.next
        slow.next = None
        return head
