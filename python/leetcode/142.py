class Solution(object):
    def detectCycle(self, head):
        if not head or not head.next:
            return None
        slow, fast = head, head
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
            if slow == fast:
                break
        if slow == fast:
            slow = head
            while slow != fast:
                fast = fast.next
                slow = slow.next
            return slow
        return None
