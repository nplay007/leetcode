class Solution:
    def reverseVowels(self, s):
        if len(s) < 2:
            return s
        l, r = 0, len(s) - 1
        while l < r:
            while l < r and s[l] not in "aeiouAEIOU":
                l += 1
            while l < r and s[r] not in "aeiouAEIOU":
                r -= 1
            s[r], s[l] = s[l], s[r]
            l += 1
            r -= 1
        return s
