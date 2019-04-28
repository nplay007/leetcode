class Solution(object):
    def maxRotateFunction(self, nums):
        if not nums: return 0
        res = sum([i * nums[i] for i in xrange(len(nums))])
        total, n, tmp = sum(nums), len(nums), res
        for idx in xrange(-1, - n - 1, -1):
            res = max(res, tmp)
            tmp += total - (n * nums[idx])
        return res