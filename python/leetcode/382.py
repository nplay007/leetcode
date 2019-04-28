class Solution(object):
    def __init__(self, head):
        self.head = head

    def getRandom(self):
        import random
        res, n, head = -1, 0, self.head
        while head:
            if random.randint(0, n) == 0:
                res = head.val
            head = head.next
            n += 1
        return res
