class Solution(object):
    def getModifiedArray(self, length, updates):
        res = [0] * length
        for update in updates:
            start, end, inc = update
            res[start] += inc
            if end < length - 1:
                res[end + 1] -= inc
        ans = 0
        for i in range(length):
            ans += res[i]
            res[i] = ans
        return res