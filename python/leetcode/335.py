def isSelfCrossing(self, x):
    return any(d >= b > 0 and (a >= c or a >= c-e >= 0 and f >= d-b)
               for a, b, c, d, e, f in ((x[i:i+6] + [0] * 6)[:6]
                                        for i in xrange(len(x))))


class Solution:
    def isSelfCrossing(self, x):
        b = c = d = e = 0
        for a in x:
            if d >= b > 0 and (a >= c or a >= c-e >= 0 and f >= d-b):
                return True
            b, c, d, e, f = a, b, c, d, e
        return False