class Solution(object):
    def maxProfit(self, prices):
        if not prices: return 0
        res = 0
        for i in range(1, len(prices)):
            if prices[i] > prices[i-1]:
                res += prices[i] - prices[i-1]
        return res


class Solution:
    def maxProfit(self, prices):
        if not prices: return 0
        i, valley, peak, res, n = 0, prices[0], prices[0], 0, len(prices)
        while i < n - 1:
            while i < n - 1 and prices[i] >= prices[i + 1]:
                i += 1
            valley = prices[i]
            while i < n - 1 and prices[i] <= prices[i + 1]:
                i += 1
            peak = prices[i]
            res += peak - valley
        return res