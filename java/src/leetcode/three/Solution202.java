package JavaAnswer.three;

import java.util.HashSet;
import java.util.Set;

class Solution202Set {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (set.add(n)) {
            int next = 0;
            while (n != 0) {
                next += (n % 10) * (n % 10);
                n /= 10;
            }
            if (next == 1) {
                return true;
            }
            n = next;
        }
        return false;
    }
}

public class Solution202 {
    public boolean isHappy(int n) {
        int fast = n, slow = n;
        do {
            fast = getNext(getNext(fast));
            slow = getNext(slow);
        }
        while (fast != slow);
        return fast == 1;
    }

    private int getNext(int n) {
        int next = 0;
        while (n != 0) {
            next += (n % 10) * (n % 10);
            n /= 10;
        }
        return next;
    }
}