class RandomListNode:
    def __init__(self, x):
        self.label = x
        self.next = None
        self.random = None

class Solution:
    def copyRandomList(self, head):
        #make copy of each node,link them in a single list.
        if not head: return None
        ptr = head
        while ptr:
            copy = RandomListNode(ptr.label)
            copy.next = ptr.next
            ptr.next = copy
            ptr = ptr.next.next
        #assign random pointers for the copy nodes.
        ptr = head
        while ptr:
            if ptr.random: ptr.next.random = ptr.random.next
            ptr = ptr.next.next
        #restore the original list, and extract the copy list.
        ptr, dummy = head, RandomListNode(0)
        pre = dummy
        while ptr:
            pre.next = ptr.next
            pre = pre.next
            ptr.next = ptr.next.next
            ptr = ptr.next 
        return dummy.next