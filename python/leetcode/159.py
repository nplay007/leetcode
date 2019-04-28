class Solution:
    def lengthOfLongestSubstringTwoDistinct(self, s):
        if len(s) < 1: return len(s)
        index = {}
        left, right, res = 0, 0, 0
        while right < len(s):
            if len(index) <= 2:
                index[s[right]] = right
                right += 1
            if len(index) > 2:
                leftMost = len(s)
                for i in index.values():
                    leftMost = min(leftMost, i)
                del index[s[leftMost]]
                left = leftMost+1
            res = max(res, right - left)
        return res



class Solution(object):
    def lengthOfLongestSubstringTwoDistinct(self, s):
        d, l, res = {}, 0, 0
        for i in range(len(s)):
            d[s[i]] = d.get(s[i], 0) + 1
            while len(d) > 2:
                d[s[l]] -= 1
                if d[s[l]] == 0: del d[s[l]]
                l += 1
            res = max(res, i - l + 1)
        return res