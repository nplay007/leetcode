class Solution:
    def canAttendMeetings(intervals):
        intervals.sort(key = lambda x: x.start)
        end = intervals[0].end
        for i in range(1, len(intervals)):
            if intervals[i].start < end: return False
            end = max(end, intervals[i].end)
        return True 