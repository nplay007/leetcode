class Solution(object):
    def integerBreak(self, n):
        dp = [0] * (n + 1)
        dp[1], dp[2] = 1, 1
        for i in range(3, n + 1):
            res = 0
            for j in range(1, i / 2 + 1):
                res = max(res, max(j, dp[j]) * max(i - j, dp[i - j]))
            dp[i] = res
        return dp[-1]


class Solution(object):
    def integerBreak(self, n):
        if n == 2:
            return 1
        elif n == 3:
            return 2
        elif n % 3 == 0:
            return 3 ** (n / 3)
        elif n % 3 == 1:
            return 2 * 2 * 3 ** ((n - 4) / 3)
        else:
            return 2 * 3 ** (n / 3)
