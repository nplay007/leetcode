class Solution:
    def maxProfit(self, prices):
        if not prices: return 0
        res = 0
        minprice = prices[0]
        for price in prices:
            minprice = min(minprice, price)
            res = max(res, price - minprice)
        return res