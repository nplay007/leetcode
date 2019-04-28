class Solution(object):
    def insert(self, intervals, newInterval):
        start, end = newInterval.start, newInterval.end
        left = [item for item in intervals if item.end < start]
        right = [item for item in intervals if item.start > end]
        if left + right != intervals:
            start = min(start, intervals[len(left)].start)
            end = max(end, intervals[~len(right)].end)  
            # ~len(right) = - len(right) - 1
        return left + [Interval(start, end)] + right