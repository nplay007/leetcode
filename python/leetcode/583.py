class Solution(object):
    def minDistance(self, word1, word2):
        len1, len2 = len(word1), len(word2)
        dp = [[0] * (len2 + 1) for x in range(len1 + 1)]
        for x in range(len1 + 1):
            for y in range(len2 + 1):
                if x == 0 or y == 0:
                    dp[x][y] = x + y
                elif word1[x - 1] == word2[y - 1]:
                    dp[x][y] = dp[x - 1][y - 1]
                else:
                    dp[x][y] = min(dp[x - 1][y], dp[x][y - 1]) + 1
        return dp[len1][len2]


class Solution(object):
    def minDistance(self, word1, word2):
        return len(word1) + len(word2) - 2 * self.lcs(word1, word2)

    def lcs(self, word1, word2):
        len1, len2 = len(word1), len(word2)
        dp = [[0] * (len2 + 1) for x in range(len1 + 1)]
        for x in range(len1):
            for y in range(len2):
                dp[x + 1][y + 1] = max(dp[x][y + 1], dp[x + 1][y])
                if word1[x] == word2[y]:
                    dp[x + 1][y + 1] = dp[x][y] + 1
        return dp[len1][len2]