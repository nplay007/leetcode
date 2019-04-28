package JavaAnswer.one;

import java.util.PriorityQueue;

import JavaAnswer.ListNode;

public class Solution023 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode ptr = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((l1, l2) -> (l1.val - l2.val));
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.offer(lists[i]);
            }
        }
        while (!pq.isEmpty()) {
            ptr.next = pq.poll();
            ptr = ptr.next;
            if (ptr.next != null) {
                pq.offer(ptr.next);
            }
        }
        return dummy.next;
    }
}

class Solution023II {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)    return null;
        return mergeKLists(lists, 0, lists.length - 1);
    }
    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start == end)
            return lists[start];
        if (start < end){
            int mid = (end - start) / 2 + start;
            ListNode left = mergeKLists(lists, start, mid);
            ListNode right = mergeKLists(lists, mid + 1, end);
            return mergeTwoLists(left, right);
        }
        return null;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)     return l2;
        if (l2 == null)     return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }
}