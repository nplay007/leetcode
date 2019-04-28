import heapq
class Solution:
    def nthSuperUglyNumber(self, n, primes):
        res = [1]
        def gen(prime):
            for ugly in res:
                yield ugly * prime
        merged = heapq.merge(*map(gen, primes))
        while len(res) < n:
            ugly = next(merged)
            if ugly != res[-1]:
                res.append(ugly)
        return res[-1]