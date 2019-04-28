class Solution(object):
    def nthUglyNumber(self, n):
        idx2, idx3, idx5, res = 0, 0, 0, [1]
        for i in xrange(1, n):
            tmp = min(res[idx2]*2, min(res[idx3]*3, res[idx5]*5))
            if tmp == res[idx2]*2: idx2 += 1
            if tmp == res[idx3]*3: idx3 += 1
            if tmp == res[idx5]*5: idx5 += 1
            res.append(tmp)
        return res[-1]