class Solution(object):
    def __init__(self, nums):
        self.nums = nums

    def pick(self, target):
        from random import randint
        res, cnts = 0, 0
        for i, num in enumerate(self.nums):
            if num == target:
                cnts += 1
                idx = randint(0, i) % cnts
                if idx == 0:
                    res = i
        return res
