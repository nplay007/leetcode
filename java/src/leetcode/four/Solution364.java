package JavaAnswer.four;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import JavaAnswer.NestedInteger;

public class Solution364 {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null) {
            return 0;
        }
        Queue<NestedInteger> queue = new LinkedList<>();
        int prev = 0, total = 0;
        for (NestedInteger next : nestedList) {
            queue.offer(next);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            int levelSum = 0;
            for (int i = 0; i < size; i++) {
                NestedInteger current = queue.poll();
                if (current.isInteger()) {
                    levelSum += current.getInteger();
                }
                List<NestedInteger> nextList = current.getList();
                if (nextList != null) {
                    for (NestedInteger next : nextList) {
                        queue.offer(next);
                    }
                }
            }
            prev += levelSum;
            total += prev;
        }
        return total;
    }
}