def maxProfit(self, prices):
    notHold, cooldown, hold = 0, float('-inf'), float('-inf')
    for p in prices:
        hold, notHold, cooldown = max(hold, notHold - p), max(notHold, cooldown), hold + p
    return max(notHold, cooldown)