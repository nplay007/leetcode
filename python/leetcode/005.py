# find longest each time, o(n^2)
class Solution(object):
    def longestPalindrome(self, s):
        if not s:
            return ""
        start, end, maxlen = 0, 0, 0
        for i in range(len(s)):
            left, right = self.help(s, i, i)
            if right - left - 1 > maxlen:
                maxlen = right - left - 1
                start, end = left+1, right-1
            left, right = self.help(s, i, i+1)
            if right - left - 1 > maxlen:
               maxlen = right - left - 1
               start, end = left+1, right-1
        return s[start: end+1]

    def help(self, s, l, r):
        while l > -1 and r < len(s) and s[l] == s[r]:
            l -= 1
            r += 1
        return l, r



# Manacher's Algorithm, O(n)
class Solution(object):
    def longestPalindrome(self, s):
        t = '^#' + '#'.join(list(s)) + '#$'
        n = len(t)
        dp = [0] * n
        cid, right, mid, span = 0, 0, 0, 0
        for i in range(1, n-1):
            dp[i] = min(right - i, dp[cid * 2 - i]) if i < right else 0
            while t[i - 1 - dp[i]] == t[i + 1 + dp[i]]:
                dp[i] += 1
            if i + dp[i] > right:
                cid, right = i, i + dp[i]
            if dp[i] > span:
                mid, span = i, dp[i]
        return s[(mid - span)/2 : (mid + span)/2]
