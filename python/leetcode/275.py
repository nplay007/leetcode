class Solution(object):
    def hIndex(self, citations):
        n = len(citations)
        l, r = 0, n - 1
        while l <= r:
            mid = l + (r - l) / 2
            if n - mid > citations[mid]: l = mid + 1
            else: r = mid - 1
        return n - l