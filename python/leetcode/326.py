class Solution(object):
    def isPowerOfThree(self, n):
        """
        :type n: int
        :rtype: bool
        """
        if n == 0: return False
        while n % 3 == 0:
            n /= 3
        return n == 1

    def isPowerOfThreeR(self, n):
        """
        :type n: int
        :rtype: bool
        """
        if n <= 0: return False
        if n == 1: return True
        return n % 3 == 0 and self.isPowerOfThreeR(n / 3)

    def isPowerOfThree(self, n):
        return n > 0 == 3**19 % n


if __name__ == '__main__':
    test = Solution()
    print test.isPowerOfThree(1)