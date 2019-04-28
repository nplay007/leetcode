# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class LinkedList:
    def reverse(self, root):
        ptr, res = root, None
        while ptr:
            tmp = ptr.next
            ptr.next = res
            res = ptr
            ptr = tmp
        return res

    def reverseR(self, head):
        if head is None or head.next is None:
            return head
        tail = head.next
        head.next = None
        newhead = self.reverseR(tail)
        tail.next = head  # tail is the end of the reverse Recursion list.
        return newhead

    def reverse(self, start, end):
        ptr = ListNode(0)
        ptr.next = start
        while ptr.next != end:
            tmp = start.next
            start.next = tmp.next
            tmp.next = ptr.next
            ptr.next = tmp
        return [end, start]

    def printList(self, root):
        while root:
            print root.val
            root = root.next

if __name__ == "__main__":
    root = ListNode(0)
    ptr = root
    for i in range(1, 10):
        node = ListNode(i)
        ptr.next = node
        ptr = ptr.next
    test = LinkedList()
    test.printList(root)
    root = test.reverseR(root)
    test.printList(root)
