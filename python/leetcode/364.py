class Solution(object):
    def depthSumInverse(self, nestedList):
        maxDeep = self.dfsDeep(nestedList)
        return self.dfsHelper(nestedList, 1, maxDeep)

    def dfsDeep(self, nestedList):
        if len(nestedList) == 1 and nestedList[0].isInteger():
            return 1
        deep = 0
        for nInt in nestedList:
            if nInt.isInteger():
                deep = max(deep, 1)
            else:
                deep = max(self.dfsDeep(nInt.getList()) + 1, deep)
        return deep

    def dfsHelper(self, nestedList, level, maxDeep):
        if len(nestedList) == 1 and nestedList[0].isInteger():
            return (maxDeep - level + 1) * nestedList[0].getInteger()
        s = 0
        for nInt in nestedList:
            if nInt.isInteger():
                s += (maxDeep - level + 1) * nInt.getInteger()
            else:
                s += self.dfsHelper(nInt.getList(), level + 1, maxDeep)
        return s