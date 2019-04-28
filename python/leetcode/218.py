from heapq import *
class Solution:
    def getSkyline(self, buildings):
        res. live = [], []
        i, n = 0, len(buildings)
        while i < n or live:
            if not live or i < n and buildings[i][0] <= -live[0][1]:
                x = buildings[i][0]
                while i < n and buildings[i][0] == x:
                    heappush(live, (-buildings[i][2], -buildings[i][1]))
                    i += 1
            else:
                x = -live[0][1]
                while live and -live[0][1] <= x:
                    heappop(live)
            height = len(live) and -live[0][0]
            if not res or height != res[-1][1]:
                res += [x, height],
        return res