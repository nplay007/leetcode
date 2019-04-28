package JavaAnswer.one;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import JavaAnswer.Interval;

public class Solution056 {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
//        Collections.sort(intervals, new Comparator<Interval>() {
//            @Override
//            public int compare(Interval i1, Interval i2) {
//                return i1.start - i2.start;
//            }
//        });
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        List<Interval> result = new ArrayList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (interval.start <= end) {
                end = Math.max(end, interval.end);
            }
            else {
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        result.add(new Interval(start, end));
        return result;
    }
}