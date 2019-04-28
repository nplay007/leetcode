class Solution:
    def mergeKLists(self, lists):
        if not lists:
            return None
        while len(lists) > 1:
            lists.append(self.mergeLists(lists[0], lists[1]))
            del lists[0]
            del lists[0]
        return lists[0]

    def mergeLists(self, l1, l2):
        if not l1 or not l2:
            return l1 if l1 else l2
        if l1.val < l2.val:
            l1.next = self.mergeLists(l1.next, l2)
            return l1
        else:
            l2.next = self.mergeLists(l1, l2.next)
            return l2




class Solution(object):
    def mergeKLists(self, lists):
        h = [(node.val, node) for node in lists if node]
        heapify(h)
        dummy = ListNode(0)
        ptr = dummy
        while h:
            val, node = heappop(h)
            ptr.next = node
            ptr = ptr.next
            if node.next:
                heappush(h, (node.next.val, node.next))
        return dummy.next
