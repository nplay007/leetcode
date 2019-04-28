class Solution:
    def permuteUnique(self, num):
        if len(num) == 1:
            return [num]
        res, data = [], []
        for i in range(len(num)):
            if num[i] not in data:
                data.append(num[i])
                for item in self.permuteUnique(num[:i] + num[i+1:]):
                    res.append([num[i]] + item)
        return res