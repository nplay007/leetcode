class Solution:
    def check(self, s, dict):
        dp = [False for i in range(len(s) + 1)]
        dp[0] = True
        for i in range(1, len(s) + 1):
            for k in range(0, i):
                if dp[k] and s[k:i] in dict:
                    dp[i] = True
        return dp[len(s)]

    def dfs(self, s, dict, ans, res):
        if self.check(s, dict):
            if len(s) == 0: res.append(ans[1:])
            for i in range(1, len(s) + 1):
                if s[:i] in dict:
                    self.dfs(s[i:], dict, ans + ' ' + s[:i], res)

    def wordBreak(self, s, dic):
        res = []
        self.dfs(s, dic, '', res)
        return res


class Solution(object):
    def wordBreak(self, s, wordDict):
        token = dict()
        return self.dfs(s, wordDict, token)
    
    def dfs(self, s, wordDict, token):
        ans = []
        if s in wordDict: ans.append(s)
        for i in range(len(s)):
            prefix, suffix = s[:i], s[i:]
            if prefix not in wordDict: continue
            rest = []
            if suffix in token: rest = token[suffix]
            else: rest = self.dfs(suffix, wordDict, token)
            for item in rest: ans.append(prefix + ' ' + item)
        token[s] = ans
        return ans