class Solution(object):
    def sortList(self, head):
        if not head or not head.next: return head
        fast, slow = head.next, head
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
        nhead = slow.next
        slow.next = None
        l1 = self.sortList(head)
        l2 = self.sortList(nhead)
        return self.merge(l1, l2)
    
    def merge(self, l1, l2):
        if not l1 or not l2: return l1 if l1 else l2
        head = ListNode(0)
        ptr = head
        while l1 and l2:
            if l1.val < l2.val:
                ptr.next = l1
                l1 = l1.next
            else:
                ptr.next = l2
                l2 = l2.next
            ptr = ptr.next
        ptr.next = l1 if l1 else l2
        return head.next