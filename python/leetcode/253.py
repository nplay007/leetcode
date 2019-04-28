class Solution:
    def minMeetingRooms(self, intervals):
        starts, ends = [], []
        for item in intervals:
            starts.append(item.start)
            ends.append(item.end)
        starts.sort()
        ends.sort()
        i, j = 0, 0
        total, exist = 0, 0
        while i < len(starts):
            if starts[i] < ends[j]:  
                if exist == 0: total += 1
                else: exist -= 1
                i += 1
            else:   
                exist += 1
                j += 1
        return total