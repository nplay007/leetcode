class Solution(object):
    def findMinArrowShots(self, points):
        points = sorted(points, key = lambda x: x[1])
        res, end = 0, -float('inf')
        for point in points:
			if point[0] > end:
				res += 1
				end = point[1]
        return res
