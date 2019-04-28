package JavaAnswer.four;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import JavaAnswer.Interval;

class SummaryRanges {
    TreeMap<Integer, Interval> map; // key is the lower of Interval

    public SummaryRanges() {
        map = new TreeMap<>();
    }

    public void addNum(int val) {
        if (map.containsKey(val)) {
            return;
        }
        Integer low = map.lowerKey(val); // key less than val
        Integer high = map.higherKey(val); // key larger than val
        // val just between two Interval, like [1, 1], [3, 5] and 2
        if (low != null && high != null && map.get(low).end + 1 == val && high == val + 1) {
            map.get(low).end = map.get(high).end;
            map.remove(high);
        }
        //val is in the lower Interval, like [1, 1] and 2
        else if (low != null && map.get(low).end + 1 >= val) {
            map.get(low).end = Math.max(map.get(low).end, val);
        }
        // val is in the higher Interval, [3, 3] and 2
        else if (high != null && high == val + 1) {
            map.put(val, new Interval(val, map.get(high).end));
            map.remove(high);
        }
        else {
            map.put(val, new Interval(val, val));
        }
    }

    public List<Interval> getIntervals() {
        return new ArrayList<>(map.values());
    }
}