class Solution(object):
    def increasingTriplet(self, nums):
        num1, num2 = 2**31, 2**31
        for item in nums:
            if item <= num1:
                num1 = item  # find the first number
            elif item <= num2:
                num2 = item # find the second small number
            else:
                return True # find the third number
        return False
