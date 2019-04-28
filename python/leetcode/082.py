class Solution(object):
    def deleteDuplicates(self, head):
        if not head: return None
        dumpy = ListNode(0)
        dumpy.next = head
        slow, fast = dummy, head
        while fast:
            while fast.next and fast.val == fast.next.val:
                fast = fast.next
            if slow.next == fast:  slow = slow.next
            else: slow.next = fast.next  
            fast = fast.next
        return dumpy.next