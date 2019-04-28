class Solution:
    def rob(self, num):
        n = len(num)
        dp = [0 for i in range(n + 1)]
        for i in range(1, n + 1):
            dp[i] = max(dp[i - 1], num[i - 1] + dp[i - 2])
        return dp[n]

class Solution:
    def rob(self, nums):
        cur, pre = 0, 0
        for val in nums:
            cur, pre = max(cur, pre + val), cur
        return cur
