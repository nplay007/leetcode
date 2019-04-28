class Solution(object):
    def isPowerOfFour(self, num):
        if num == 1:
            return True
        if num == 0:
            return False
        return (num % 4) == 0 and self.isPowerOfFour(num / 4)


class Solution(object):
    def isPowerOfFour(self, num):
        return num > 0 and (num & (num - 1)) == 0 and (num & 0x55555555) != 0
