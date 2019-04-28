class Solution:
    def merge(self, intervals):
        if not intervals:
            return []
        res = []
        for item in sorted(intervals, key=lambda x: x.start):
            if res and item.start <= res[-1].end:
                res[-1].end = max(res[-1].end, item.end)
            else:
                res.append(item)
        return res
