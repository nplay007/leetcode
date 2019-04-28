class Solution:
    def coinChange(self, coins, amount):
        n = amount + 1
        dp = [n] * n
        dp[0] = 0
        for j in range(len(coins)):
            for i in range(coins[j], n):
                    dp[i] = min(dp[i], dp[i - coins[j]] + 1)
        if dp[amount] > amount: return -1
        else: return dp[amount]
