class Solution(object):
    def isPalindrome(self, x):
        if x < 0 or (x % 10 == 0 and x != 0):
            return False
        y = 0
        while y < x:
            y = 10 * y + x % 10
            x /= 10
        return y == x or y / 10 == x
