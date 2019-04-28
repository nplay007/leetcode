class Solution:
    def generateAbbreviations(self, word):
        res = []
        self.backtrack(0, 0, word, "", res)
        return res

    def backtrack(self, pos, count, word, ans, res):
        if pos == len(word):
            if count > 0: ans += str(count)
            res.append(ans)
        else:
            self.backtrack(pos + 1, count + 1, word, ans, res)
            tmp = str(count) if count > 0 else ""
            self.backtrack(pos + 1, 0, word, ans + tmp + word[pos], res)