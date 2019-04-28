class Solution {
public:
    vector<Interval> merge(vector<Interval>& intervals) {
        sort(intervals.begin(), intervals.end(), [](Interval a, Interval b) {return a.start < b.start;});
        vector<Interval> res;
        for (Interval item : intervals) {
            if (!res.empty() && res.back().end >= item.start) {
                res.back().end = max(res.back().end, item.end);
            } else {
                res.push_back(item);
            }
        }
        return res;
    }
};