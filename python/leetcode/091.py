class Solution:
    def numDecodings(self, s):
        if not s:
            return 0
        n = len(s)
        dp = [0 for i in range(n + 1)]  # dp[0] is used as initial
        dp[0] = 1
        for i in range(1, n + 1):
            if 0 < int(s[i - 1]) < 10:
                dp[i] = dp[i - 1]
            if i >= 2 and 9 < int(s[i - 2:i]) < 27:
                dp[i] += dp[i - 2]
        return dp[n]


class Solution:
    def numDecodings(self, s):
        if not s:
            return 0
        pre, cur = 1, 1
        for i in range(1, len(s) + 1):
            if int(s[i-1]) < 1 or int(s[i-1]) > 9:
                cur = 0
            if i > 1 and 9 < int(s[i-2: i]) < 27:
                cur = pre + cur
                pre = cur - pre
            else:
                pre = cur
        return curr