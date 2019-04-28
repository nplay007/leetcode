package JavaAnswer.four;

import java.util.Random;

import JavaAnswer.ListNode;

public class Solution382 {
    ListNode head;
    Random random;

    public Solution382(ListNode head) {
        this.head = head;
        random = new Random();
    }

    public int getRandom() {
        ListNode res = null, current = head;
        for (int i = 1; current != null; i++) {
            if (random.nextInt(i) == 0) {
                res = current;
            }
            current = current.next;
        }
        return res.val;
    }
}
