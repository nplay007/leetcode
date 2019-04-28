class Solution:
    def deleteDuplicates(self, head):
        ptr = head
        while ptr:
            while ptr.next and ptr.next.val == ptr.val:
                ptr.next = ptr.next.next     # skip duplicated node
            ptr = ptr.next   # not duplicate of ptrrent node, move to next node
        return head
