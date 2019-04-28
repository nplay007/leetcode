class Solution:
    def rob(self, num):
        if not num: return 0
        if len(num) == 1: return num[0]
        return max(self.rob_noloop(num[1::]), self.rob_noloop(num[:-1:]))

    def rob_noloop(self, num):
        n = len(num)
        dp = [0 for i in range(n+1)]
        for i in range(1, n+1):
            dp[i] = max(dp[i-1], num[i-1] + dp[i-2])
        return dp[n]

    def rob_noloop_greedy(self, nums):
        cur = pre = 0
        for val in nums:
            cur, pre = max(cur, pre + val), cur
        return cur

