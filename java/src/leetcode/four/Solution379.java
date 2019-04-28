package JavaAnswer.four;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class PhoneDirectory {
    int max;
    Set<Integer> set;
    Queue<Integer> queue;

    public PhoneDirectory(int maxNumbers) {
        set = new HashSet<>();
        queue = new LinkedList<>();
        for (int i = 0; i < maxNumbers; i++) {
            queue.offer(i);
        }
        max = maxNumbers - 1;
    }

    public int get() {
        if (queue.isEmpty()) {
            return -1;
        }

        int num = queue.poll();
        set.add(num);
        return num;
    }

    public boolean check(int number) {
        return !set.contains(number) && number <= max;
    }

    public void release(int number) {
        if (set.contains(number)) {
            set.remove(number);
            queue.offer(number);
        }
    }
}