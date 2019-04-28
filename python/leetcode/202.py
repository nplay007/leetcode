class Solution:
    def isHappy(self, n):
        res = set()
        while True:
            res.add(n)
            n = sum([int(x) * int(x) for x in str(n)])
            if n == 1 or n in res:
                break
        return n == 1


class Solution:
    def isHappy(self, n):
        slow, fast = n, n
        while True:
            slow = sum([int(x) * int(x) for x in str(slow)])
            fast = sum([int(x) * int(x) for x in str(fast)])
            fast = sum([int(x) * int(x) for x in str(fast)])
            if fast == slow:
                break
        return slow == 1
