class Solution(object):
    def isRectangleCover(self, rectangles):
        if not rectangles or not rectangles[0]: return False
        INT_MAX, INT_MIN = 2*31 - 1, -2**31
        x1, x2, y1, y2 = INT_MAX, INT_MIN, INT_MAX, INT_MIN
        m, area = set(), 0
        for rect in rectangles:
            x1, y1 = min(x1, rect[0]), min(y1, rect[1])
            x2, y2 = max(x2, rect[2]), max(y2, rect[3])
            area += (rect[2] - rect[0]) * (rect[3] - rect[1])
            s1 = str(rect[0]) + " " + str(rect[1])
            s2 = str(rect[0]) + " " + str(rect[3])
            s3 = str(rect[2]) + " " + str(rect[3])
            s4 = str(rect[2]) + " " + str(rect[1])
            if s1 in m: m.discard(s1)
            else: m.add(s1)
            if s2 in m: m.discard(s2)
            else: m.add(s2)
            if s3 in m: m.discard(s3)
            else: m.add(s3)
            if s4 in m: m.discard(s4)
            else: m.add(s4)
        if (str(x1) + " " + str(y1)) not in m or (str(x1) + " " + str(y2)) not in m or \
           (str(x2) + " " + str(y1)) not in m or (str(x2) + " " + str(y2)) not in m or \
           len(m) != 4: return False;
        return area == (x2-x1) * (y2-y1);