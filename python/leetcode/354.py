class Solution(object):
    def maxEnvelopes(self, envelopes):
        def bin_search(A, key):
            l, r = 0, len(A)
            while l < r:
                mid = (l + r) / 2
                if A[mid][1] < key[1]: l = mid + 1
                else: r = mid
            return l

        envelopes.sort(
            cmp=lambda x, y: x[0] - y[0] if x[0] != y[0] else y[1] - x[1])
        n = len(envelopes)
        tails = []
        for i in range(n):
            e = envelopes[i]
            p = bin_search(tails, e)
            if p == len(tails): tails.append(e)
            else: tails[p] = e
        return len(tails)