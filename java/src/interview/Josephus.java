package interview;

public class Josephus {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    };

    public int Dynamic(int n, int k) {
        if (n == 1)
            return 1;
        return (Dynamic(n - 1, k) + k - 1) % n + 1;
    }

    public int List(ListNode head, int k) {
        ListNode ptr = head;
        while (ptr.next != ptr) {
            for (int i = 0; i < k - 1; i++) {
                ptr = ptr.next;
            }
            ptr.next = ptr.next.next;
        }
        return ptr.val;
    }

    int JosephRingWinner(int n, int k) {
        if (n <= 0 || k <= 0) {
            return -1;
        }
        int prev = 1, cur = 1;
        for (int i = 2; i <= n; ++i) {
            int firstOut = (k - 1) % i + 1; // the person killed first
            if (firstOut == i) {
                cur = prev;
            }
            else {
                cur = ((prev - 1) + (firstOut - 1)) % (i - 1) + 1; // firstOut is also the start index for (n-1)-people
                if (cur >= firstOut) {
                    cur++; // restore index for n-people
                }
            }
            prev = cur;
        }
        return cur;
    }

}
