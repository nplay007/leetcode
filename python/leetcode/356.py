class Solution(object):
    def isReflected(self, points):
        """
        :type points: List[List[int]]
        :rtype: bool
        group points by y positions, then check x in pairs
        """
        groups = {}
        for x, y in sorted(points):
            if y not in groups:
                groups[y] = [x]
            else:
                groups[y] += x,

        possible = None
        for ls in groups.values():
            l, r = 0, len(ls) - 1
            while l <= r:
                tmp = ls[l] + ls[r]
                if tmp % 2:
                    return False
                tmp /= 2
                if possible and possible != tmp:
                    return False
                possible = tmp
                l += 1
                r -= 1
        return True


    def isReflected(self, points):
        points.sort()
        return points == sorted([points[0][0] + points[-1][0] - x, y]
                                for x, y in points)


    def isReflected(self, points):
        if not points: return True
        X = min(points)[0] + max(points)[0]
        return {(x, y) for x, y in points} == {(X - x, y) for x, y in points}