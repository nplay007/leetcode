class Solution:
    def minCost(self, costs):
        if not costs: return 0
        pre = [0] * 3
        for now in costs:
            pre = [now[i] + min(pre[:i], pre[i + 1:]) for i in range(3)]
        return min(pre)

class Solution:
    def minCost(self, costs):
        if not costs: return 0
        pre = costs[0][:]
        now = [0] * 3
        for i in range(1, n):
            now[0] = costs[i][0] + min(pre[1] + pre[2])
            now[1] = costs[i][1] + min(pre[0] + pre[2])
            now[2] = costs[i][2] + min(pre[0] + pre[1])
            pre = now
        return min(pre)