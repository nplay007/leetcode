class Solution:
    def addOperators(self, num, target):
        res = []
        for i in range(1, len(num) + 1):
            # prevent "00*" as a number
            if i == 1 or (i > 1 and num[0] != "0"):
                # this step put first number in the string
                self.dfs(target, num[i:], num[:i], int(num[:i]), int(num[:i]), res)
        return res

    def dfs(self, target, num, ans, cur, last, res):
        if not num:
            if cur == target:
                res.append(ans)
            return
        for i in range(1, len(num) + 1):
            val = num[:i]
            # prevent "00*" as a number
            if i == 1 or (i > 1 and num[0] != "0"):
                self.dfs(target, num[i:], ans + "+" + val,
                         cur + int(val), int(val), res)
                self.dfs(target, num[i:], ans + "-" + val,
                         cur - int(val), -int(val), res)
                self.dfs(target, num[i:], ans + "*" + val, cur - last +
                         last * int(val), last * int(val), res)
