class Solution(object):
    def detectCapitalUse(self, word):
        cnts, n = 0, len(word)
        for ch in word:
            if ch <= 'Z':
                cnts += 1
        return cnts == 0 or cnts == n or (cnts == 1 and word[0] <= 'Z')