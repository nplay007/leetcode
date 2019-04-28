def lengthOfLIS(self, nums):
    tails = [0] * len(nums)
    size = 0
    for num in nums:
        l, r = 0, size
        while l != r:
            m = (r - l) / 2 + l
            if tails[m] < num: l = m + 1
            else: r = m
        tails[l] = num
        size = max(l + 1, size)
    return size

class Solution(object):
    def lengthOfLIS(self, nums):
        if not nums: return 0
        n = len(nums)
        dp = [1 for _ in range(n)]
        for i in range(1, n):
            for j in range(i):
                if nums[i] > nums[j]: dp[i] = max(dp[i], dp[j] + 1)
        return max(dp)