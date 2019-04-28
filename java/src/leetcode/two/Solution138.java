package JavaAnswer.two;

import java.util.HashMap;
import java.util.Map;

import JavaAnswer.RandomListNode;

public class Solution138 {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        RandomListNode ptr = head;
        while (ptr != null) {
            RandomListNode copy = new RandomListNode(ptr.label);
            copy.next = ptr.next;
            ptr.next = copy;
            ptr = ptr.next.next;
        }
        for (ptr = head; ptr != null; ptr = ptr.next.next) {
            if (ptr.random != null) {
                ptr.next.random = ptr.random.next;
            }
        }
        RandomListNode nhead = new RandomListNode(0);
        RandomListNode cur = nhead;
        for (ptr = head; ptr != null; ptr = ptr.next) {
            cur.next = ptr.next;
            ptr.next = ptr.next.next;
            cur = cur.next;
        }
        return nhead.next;
    }
}

class Solution138II {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        RandomListNode ptr = head;
        while (ptr != null) {
            map.put(ptr, new RandomListNode(ptr.label));
            ptr = ptr.next;
        }

        ptr = head;
        while (ptr != null) {
            map.get(ptr).next = map.get(ptr.next);
            map.get(ptr).random = map.get(ptr.random);
            ptr = ptr.next;
        }
        return map.get(head);
    }
}

class Solution138III {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode dummy = new RandomListNode(0), cur = dummy;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while (head != null) {
            RandomListNode newNode = null;
            if (map.containsKey(head))
                newNode = map.get(head);
            else {
                newNode = new RandomListNode(head.label);
                map.put(head, newNode);
            }
            if (head.random != null) // ATTENTION
                if (map.containsKey(head.random))
                    newNode.random = map.get(head.random);
                else {
                    newNode.random = new RandomListNode(head.random.label);
                    map.put(head.random, newNode.random);
                }
            cur.next = newNode;
            cur = cur.next;
            head = head.next;
        }
        return dummy.next;
    }
}