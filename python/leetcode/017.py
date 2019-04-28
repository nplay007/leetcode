class Solution:
    def letterCombinations(self, digits):
        table = {'2': 'abc', '3': 'def', '4': 'ghi', '5': 'jkl',
                 '6': 'mno', '7': 'pqrs', '8': 'tuv', '9': 'wxyz'}
        if len(digits) == 0:
            return []
        if len(digits) == 1:
            return list(table[digits[0]])
        pre = self.letterCombinations(digits[:-1])
        add = table[digits[-1]]
        return [s + c for s in pre for c in add]


class Solution(object):
    def letterCombinations(self, digits):
        res = []
        if not digits:
            return res
        table = {'2': 'abc', '3': 'def', '4': 'ghi', '5': 'jkl',
                 '6': 'mno', '7': 'pqrs', '8': 'tuv', '9': 'wxyz'}
        self.dfs(table, digits, 0, "", res)
        return res

    def dfs(self, table, digits, n, ans, res):
        if n == len(digits):
            res.append(ans)
            return
        for ch in table[digits[n]]:
            self.dfs(table, digits, n + 1, ans + ch, res)
