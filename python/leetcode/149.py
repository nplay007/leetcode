class Solution(object):
    def maxPoints(self, points):
        n, res = len(points), -1
        if n < 3: return n
        for i in range(n):
            slope = {'inf' : 0}
            same = 1
            for j in range(i+1, n):
                if points[i].x == points[j].x and points[i].y == points[j].y: same += 1
                elif points[i].x == points[j].x and points[i].y != points[j].y: slope['inf'] += 1
                else: 
                    k = float((points[j].y - points[i].y))/(points[j].x - points[i].x)
                    slope[k] = slope.get(k, 0) + 1
            res = max(res, max(slope.values()) + same)
        return res