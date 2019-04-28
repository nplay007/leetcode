class Solution(object):
    def getPermutation(self, n, k):
        factor, res = [1] * n, ""
        for i in range(1, n): factor[i] = factor[i-1] * i
        num = ['1', '2', '3', '4', '5', '6', '7', '8', '9']
        k -= 1
        for i in xrange(n, 0, -1):
            digit = num[k/factor[i-1]]
            res += str(digit)
            num.remove(digit)
            k %= factor[i-1]
        return res