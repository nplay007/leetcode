class Solution:
    def myPow(self, x, n):
        if n == 0:
            return 1.0
        if n < 0:
            n, x = -n, 1.0/x
        return self.myPow(x * x, n/2) if n % 2 == 0 else x * self.myPow(x * x, n/2)