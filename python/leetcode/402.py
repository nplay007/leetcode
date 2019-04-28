class Solution(object):
    def removeKdigits(self, num, k):
        res = []
        self.help(num, k, res)
        ans = "".join(res).lstrip("0")
        return "0" if not ans else ans

    def help(self, num, n, res):
        if n == 0:
            res.append(num)
            return
        length = len(num)
        if length <= n: return
        idx = 0
        for i in range(1, n+1):
            if num[i] < num[idx]:
                idx = i
        res.append(num[idx])
        newstr = num[idx+1:]
        self.help(newstr, n - idx, res)
