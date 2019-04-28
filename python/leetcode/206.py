class Solution(object):
    def reverseList(self, head):
        if not head or not head.next:
            return head
        tmp = head.next
        nhead = self.reverseList(tmp)
        tmp.next = head
        head.next = None
        return nhead
        

class Solution(object):
    def reverseList(self, head):
        if not head or not head.next: 
            return head 
        nhead = None
        while head:
            tmp = head.next
            head.next = nhead
            nhead = head
            head = tmp
        return nhead