from random import randint
class Solution(object):
    def __init__(self, nums):
        self.nums = nums

    def reset(self):
        return self.nums

    def shuffle(self):
        res, n = self.nums[:], len(self.nums)
        for i in range(n):
            r = random.randint(0,i) #[0, i]
            res[i], res[r] = res[r], res[i]
        return res

        # idx = shuffle(n)
        # return [self.nums[i] for i in idx]