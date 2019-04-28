class Solution(object):
    def countPrimes(self, n):
        if n <= 1:
            return 0
        prime = [1] * n
        prime[0], prime[1] = 0, 0
        i = 2
        while i * i < n:
            prime[i * i: n: i] = [0] * ((n - 1 - i * i) / i + 1)
            i += 1
        return sum(prime)
