package interview;


// Return the exact time that has max num of room used (any valid time)
// 和原题基本一样，只需想明白最后一次overlapStart - overlapEnd之间的任意时间都使用了最大数目的房间。
// 所以you can return any time between overlapStart and overlapEnd

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import JavaAnswer.Interval;

public class MeetingRooms {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        Queue<Integer> heap = new PriorityQueue<>();//no need to store interval, we can just store the end time
        heap.offer(intervals[0].end);
        int overlapStart = -1;
        // int overlapEnd = -1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= heap.peek()) {//if can use room that ends earliest,poll that end time,add curr end time
                heap.poll();
            } else {
                overlapStart = intervals[i].start;
                // overlapEnd = Math.min(heap.peek(), intervals[i].end);//should be min of these two
            }
            heap.offer(intervals[i].end);//add curr end time
        }
        return overlapStart;//you can return any time between overlapStart and overlapEnd
    }

    // Return the num of room used / employees of each non-overlapping time range(you can design you own output
    // [2004,2007],[2005,2007],[2006,2008]->2004-2005:1; 2005-2006:2; 2006-2007:3; 2007-2008:1;
    // 如果the format of intervals are "March, 2014"etc, first convert it to "201403"by "2014"+"03"(hashmap:March->03)
    // http://www.1point3acres.com/bbs/thread-109379-2-1.html


   //  问(1,2),(2,4),(3,5)该输出["1-2:1","2-3:1","3-4:2","4-5:1"]还是["1-3:1","3-4:2","4-5:1"]
   // 下面的代码是输出["1-2:1","2-3:1","3-4:2","4-5:1"]的。

    public class TimeSlot {
        int time;
        boolean isStart;

        public TimeSlot(int t, boolean i) {
            time = t;
            isStart = i;
        }
    }

    public List<String> meetingRooms(Interval[] intervals) {
        List<String> res = new ArrayList<>();
        if (intervals == null || intervals.length == 0) return res;
        List<TimeSlot> times = new ArrayList<>();
        for (Interval i : intervals) {
            times.add(new TimeSlot(i.start, true));
            times.add(new TimeSlot(i.end, false));
        }
        Collections.sort(times, new Comparator<TimeSlot>() {
            @Override
            public int compare(TimeSlot a, TimeSlot b) {
                return a.time - b.time;
            }
        });
        int count = 1, startIdx = 0;//it's the index of begin time, not the time itself
        for (int i = 1; i < times.size(); i++) {
            if (times.get(i).time != times.get(i - 1).time) {
                res.add(times.get(startIdx).time + "-" + times.get(i).time + ": " + count);
                startIdx = i;
            }
            if (times.get(i).isStart) count++;
            else count--;
        }
        return res;
    }


    // print each room usage time intervals:Room 1:[2,6],[7,9];Room 2:[3,5],[8,10];etc.
    // 返回每个房间 所有的会议 的开始时间和结束时间。

    // 把所有的interval排序一下， 建立一个priorityqueue<List<Interval>> 按照List
    // <Interval> 最后一个interval 的end来排序，如果新来的interval起点比最早结束的interval终点早，或者priorityqueue为空，
    // create 一个新的List<Interval>，否则， poll priorityqueue。 把新的interval 加进去就好了。 one pass。方法来自机经，
// http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=222745&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D2%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

    public void MeetingRoomsI(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return;
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        Queue<List<Interval>> rooms = new PriorityQueue<>(1, new Comparator<List<Interval>>() {
            @Override
            public int compare(List<Interval> a, List<Interval> b) {
                return a.get(a.size() - 1).end - b.get(b.size() - 1).end;
            }
        });
        for (Interval i : intervals) {
            List<Interval> room = null;
            if (rooms.isEmpty() || i.start < rooms.peek().get(rooms.size() - 1).end) //if need new room(no rooms/all curr rooms overlap)
                room = new LinkedList<>();
            else room = rooms.poll();//else use the previous room that ends earliest (no overlap with curr meeting)
            room.add(i);//add curr meeting into the room, which is at the back of the linkedlist
            rooms.offer(room);
        }
        while (!rooms.isEmpty()) {
            List<Interval> room = rooms.poll();
            //you can maintain a roomNum and System.out.print("Room " + roomNum + ":");
            for (Interval i : room) //print each meeting in a same room
                System.out.print("[" + i.start + "-" + i.end + "],");
            System.out.println();
        }
    }

    // Return the time ranges of free time between startTime and endTime(time ranges that have no meetings)
    public List<String> minMeetingRooms(Interval[] intervals, int start, int end) {
        List<String> res = new ArrayList<>();
        if (intervals == null || intervals.length == 0) return res;
        Arrays.sort(intervals, (a, b)->(a.start - b.start));
        int begin = start;//the beginTime of freeTime (end of last meeting)
        for (Interval i : intervals) {
            if (begin >= end) break;
            if (i.start > begin)
                res.add(begin + "-" + Math.min(i.start, end));//if the i.start exceeds end, we pick end to be the boundary
            begin = Math.max(begin, i.end);
        }
        return res;
    }


}
