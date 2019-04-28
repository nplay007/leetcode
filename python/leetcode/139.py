class Solution:
    def wordBreak(self, s, dict):
        if len(dict) == 0: return False
        n = len(s)
        dp = [False for i in range(n+1)]
        dp[0] = True
        for i in range(1, n+1):
            for k in range(i):
                if dp[k] and s[k:i] in dict:
                    dp[i] = True
        return dp[-1]