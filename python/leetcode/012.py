class Solution:
    def intToRoman(self, num):
        if num < 0:
            raise ValueError("negative num")
        romans = ['I', 'IV', 'V', 'IX', 'X', 'XL', 'L', 'XC', 'C', 'CD', 'D', 'CM', 'M']
        nums = [1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000]
        res = []
        for i in range(len(nums) - 1, -1, -1):
            while num >= nums[i]:
                res.append(romans[i])
                num -= nums[i]
        return "".join(res)
