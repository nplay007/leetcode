class Solution(object):
    def partition(self, s):
        if not s: return []
        res = [] 
        self.help(s, [], res)
        return res

    def help(self, s, ans, res):
        if not s:
            res.append(ans)
            return 
        for i in range(1, len(s) + 1):
            if s[:i] == s[:i][::-1]:
                self.help(s[i:], ans + [s[:i]], res)
        