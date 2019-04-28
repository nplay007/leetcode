class Solution:
    def majorityElement(self, nums):
        if not nums: return []
        cnts1, cnts2, num1, num2 = 0, 0, 0, 1
        for n in nums:
            if n == num1:
                cnts1 += 1
            elif n == num2:
                cnts2 += 1
            elif cnts1 == 0:
                num1, cnts1 = n, 1
            elif cnts2 == 0:
                num2, cnts2 = n, 1
            else:
                cnts1, cnts2 = cnts1 - 1, cnts2 - 1
        return [n for n in (num1, num2) if nums.count(n) > len(nums)//3]