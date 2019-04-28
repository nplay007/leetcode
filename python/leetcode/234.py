class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if not head or not head.next: return True
        fast, slow = head.next, head
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
        fast = slow.next
        slow.next, nhead = None, None
        while fast:
            tmp = fast.next
            fast.next = nhead
            nhead = fast
            fast = tmp
        while head and nhead:
            if head.val != nhead.val: return False
            head = head.next
            nhead = nhead.next
        return True