class NumArray(object):
    def __init__(self, nums):
        n = len(nums)
        self.dp = [0] * (n + 1)
        for i in range(1, n+1):
            self.dp[i] = nums[i-1] + self.dp[i-1]

    def sumRange(self, i, j):
        return self.dp[j + 1] - self.dp[i]