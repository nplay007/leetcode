class Solution(object):
    def maxCoins(self, nums):
        nums = [1] + nums + [1]
        n = len(nums)
        dp = [[0] * n for _ in xrange(n)]
        for k in range(2, n): 
            for l in range(n - k):
                r = l + k
                for m in range(l+1, r)
                    dp[l][r] = max(dp[l][r], nums[l] * nums[m] * nums[r] + dp[l][m] + dp[m][r])
        return dp[0][n - 1]