class Solution(object):
    def lengthOfLongestSubstring(self, s):
        words, last, longestSubstr = {}, 0, 0
        for i, ch in enumerate(s):
            if ch in words:
                last = max(last, words[ch] + 1)
            words[ch] = i
            longestSubstr = max(longestSubstr, i - last + 1)
        return longestSubstr
