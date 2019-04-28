class Solution:
    def findStrobogrammatic(self, n):
        # when n % 2 == 0, nums = ['']
        # else nums = ['0', '1' ,'8']
        nums = n % 2 * list('018') or ['']
        while n > 1:
            n -= 2
            nums = [a + num + b for a, b in '00 11 88 69 96'.split()[n < 2:] for num in nums]
            # when n<2, [n<2:] = [1:], no number has two 0
        return nums