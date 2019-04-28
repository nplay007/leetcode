class Solution(object):
    def minCostII(self, costs):
        if not costs or not costs[0]: return 0
        INT_MAX = 2**31
        pMin, pSec, pIdx = 0, 0, -1
        m, n = len(costs), len(costs[0])
        for i in range(m):
            curMin, curSec, curIdx = INT_MAX, INT_MAX, -1
            for j in range(n):
                x = costs[i][j]
                x += pMin if pIdx != j else pSec
                # 找出最小和次小的，最小的要记录下标，方便下一轮判断
                if x < curMin:
                    curSec, curMin, curIdx = curMin, x, j
                elif x < curSec:
                    curSec = x
            pMin, pSec, pIdx = curMin, curSec, curIdx
        return pMin