package JavaAnswer.three;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class ZigzagIterator {
    Queue<Iterator<Integer>> queue;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<>();
        if (!v1.isEmpty()) {
            queue.add(v1.iterator());
        }
        if (!v2.isEmpty()) {
            queue.add(v2.iterator());
        }
    }

    public int next() {
        Iterator<Integer> node = queue.poll();
        int res = node.next();
        if (node.hasNext()) {
            queue.add(node);
        }
        return res;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}