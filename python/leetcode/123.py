class Solution(object):
    def maxProfit(self, prices):
        uh1, uh2, h1, h2 = 0, 0, -2**31, -2**31
        for price in prices:
            uh2 = max(uh2, h2 + price)
            h2 = max(h2, uh1 - price)
            uh1 = max(uh1, h1 + price)
            h1 = max(h1, -price)
        return uh2