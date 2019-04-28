package JavaAnswer.three;

import java.util.Arrays;
import java.util.PriorityQueue;

import JavaAnswer.Interval;

public class Solution253 {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
//        Comparator<Interval> cmp = new Comparator<Interval>() {
//            @Override
//            public int compare(Interval o1, Interval o2) {
//                return o1.start - o2.start;
//            }
//
//        };
//        Arrays.sort(intervals, cmp);
        // Sort the intervals by start time
        Arrays.sort(intervals, (a, b) -> (a.start - b.start));
        // priorityQueue to track the minimum end time of intervals
        PriorityQueue<Interval> pq = new PriorityQueue<>(intervals.length, (a, b) -> a.end - b.end);
        for (Interval interval : intervals) {
            if (pq.isEmpty()) {
                pq.add(interval);
            }
            else {
                // get the meeting room that finishes earliest
                Interval top = pq.poll();
                if (top.end > interval.start) {
                    // overlap we need a new room
                    pq.add(interval);
                }
                else {
                    // merge the existing room
                    top.end = interval.end;
                }
                pq.add(top); // the previous room still need
            }
        }
        return pq.size();
    }
}