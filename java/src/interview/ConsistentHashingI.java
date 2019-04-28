package interview;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ConsistentHashingI {
    /**
     * @param n: a positive integer
     * @return n x 3 matrix
     * http://blog.csdn.net/jmspan/article/details/51740066
     */
    public List<List<Integer>> consistentHashing(int n) {
        // Write your code here
        PriorityQueue<Range> heap = new PriorityQueue<>(16, new Comparator<Range>() {
            @Override
            public int compare(Range r1, Range r2) {
                if (r1.to - r1.from > r2.to - r2.from)
                    return -1;
                if (r1.to - r1.from < r2.to - r2.from)
                    return 1;
                return r1.id - r2.id;
            }
        });
        heap.offer(new Range(1, 0, 359));
        for (int i = 2; i <= n; i++) {
            Range range = heap.poll();
            Range range1 = new Range(range.id, range.from, (range.from + range.to) / 2);
            Range range2 = new Range(i, (range.from + range.to) / 2 + 1, range.to);
            heap.offer(range1);
            heap.offer(range2);
        }
        Range[] ranges = heap.toArray(new Range[0]);
        List<List<Integer>> results = new ArrayList<>(ranges.length);
        for (int i = 0; i < ranges.length; i++) {
            List<Integer> result = new ArrayList<>(3);
            result.add(ranges[i].from);
            result.add(ranges[i].to);
            result.add(ranges[i].id);
            results.add(result);
        }
        return results;
    }
}

class Range {
    int id;
    int from, to;

    Range(int id, int from, int to) {
        this.id = id;
        this.from = from;
        this.to = to;
    }
}
