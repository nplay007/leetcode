class Solution(object):
    def lastRemaining(self, n):
        left, remain, head, step = True, n, 1, 1
        while remain > 1:
            if left or (remain % 2 == 1):
                head += step
            remain /= 2
            step *= 2
            left = not left
        return head