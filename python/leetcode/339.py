class Solution:
    def depthSum(self, nestedList):
        res = 0
        if not nestedList:
            return res
        for item in nestedList:
            res += self.getSum(item, 1)
        return res

    def getSum(self, data, level):
        res = 0
        if isinstance(data, int):
            return data * level
        if isinstance(data, []):
            for item in data:
                res += self.getSum(item, level + 1)
        return res
