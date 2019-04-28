class Solution(object):
    def superPow(self, a, b):
        res = 1
        for digit in b:
            res = pow(res, 10, 1337) * pow(a, digit, 1337) % 1337
        return res
     