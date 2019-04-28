class Solution:
    def permute(self, num):
        if len(num) == 1:
            return [num]
        res = []
        for i in range(len(num)):
            for item in self.permute(num[:i]+num[i+1:]):
                res.append([num[i]]+item)
        return res


class Solution:
    def permute(self, nums):
        res = [[]]
        for n in nums:
            ans = []
            for perm in res:
                for i in xrange(len(perm)+1):
                    ans.append(perm[:i] + [n] + perm[i:])
            res = ans
        return res