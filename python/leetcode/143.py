class Solution:
    def reorderList(self, head):
        if not head or not head.next: return
        l1, l2 = self.splitList(head)
        l2 = self.reverseList(l2)
        head = self.mergeLists(l1, l2)

    def splitList(self, head):
        fast, slow = head.next, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        middle = slow.next
        slow.next = None
        return head, middle


    def reverseList(self, head):
        pre = None
        while head:
            q = head.next
            head.next = pre
            pre = head
            head = q
        return pre


    def mergeLists(self, l1, l2):
        if not l1: return l2
        if not l2: return l1
        dummy = ListNode(0)
        ptr = dummy
        while l1 and l2:
            ptr.next = l1
            l1 = l1.next
            ptr = ptr.next
            ptr.next = l2
            l2 = l2.next
            ptr = ptr.next
        if l1: ptr.next = l1
        if l2: ptr.next = l2
        return dummy.next



class Solution(object):
    def reorderList(self, head):
        if not head or not head.next: return 
        fast, slow = head.next, head
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
        nhead = slow.next
        slow.next = None
        fast = nhead.next
        nhead.next = None
        while fast:
            tmp = fast.next
            fast.next = nhead
            nhead = fast
            fast = tmp
        slow, fast = head, nhead
        while slow:
            tmp = slow.next
            slow.next = fast
            slow = fast
            fast = tmp
        return