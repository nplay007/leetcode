class Szsolution(object):
    def singleNumber(self, nums):
        res = 0
        for item in nums:
            res ^= item
        return res