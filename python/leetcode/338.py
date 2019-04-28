class Solution(object):
    def countBits(self, num):
        ans = [0]
        for x in range(1, num + 1):
            ans += ans[x & (x - 1)] + 1,
        return ans


class Solution(object):
    def countBits(self, num):
        bits = [0] * (num + 1)
        for i in xrange(num + 1):
            bits[i] = bits[i / 2]
            if i % 2 != 0:
                bits[i] += 1
        return bits
