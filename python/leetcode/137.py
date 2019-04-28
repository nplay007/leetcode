class Solution:
    def singleNumber(self, nums):
        one, two = 0, 0
        for num in nums:
            # ones = ones ^ nums[i]; if (twos == 1) then ones = 0
            one = (one ^ num) & ~two
            # twos = twos ^ nums[i]; if (ones == 1) then twos = 0
            two = (two ^ num) & ~one
        return one
