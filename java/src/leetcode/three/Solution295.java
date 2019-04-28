package JavaAnswer.three;

import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {
    private Queue<Long> small;
    private Queue<Long> large;

    public MedianFinder() {
        small = new PriorityQueue<>();
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        small.add(-(long) num);
        large.add(-small.poll());
        if (small.size() < large.size()) {
            small.add(-large.poll());
        }
    }

    public double findMedian() {
        return small.size() == large.size() ? (large.peek() - small.peek()) / 2.0 : -small.peek();
    }
}
