class Solution {
public:
    vector<Interval> insert(vector<Interval>& intervals, Interval newInterval) {
        vector<Interval> res;
        int i = 0;
        for(; i < intervals.size(); ++i){
            if(intervals[i].end < newInterval.start) {
                res.push_back(intervals[i]);
            } else if(intervals[i].start > newInterval.end) {
                break;
            } else {
                newInterval.start = min(newInterval.start, intervals[i].start);
                newInterval.end = max(newInterval.end, intervals[i].end);
            }
        }
        res.push_back(newInterval);
        for(;i < intervals.size(); ++i) {
            res.push_back(intervals[i]);

        return res;
    }
};