class Solution(object):
    def singleNumber(self, nums):
        res = 0
        for item in nums: res ^= item
        # res is x ^ y
        # find the digit where x != y
        maker = 1
        while (maker & res) != maker:
            maker <<= 1
        x = 0
        for item in nums:
            # divide the num into 2 group, one has the same digit as x
            if maker & item:  x ^= item   # get the x value
        return [x, x ^ res]