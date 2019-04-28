package JavaAnswer.two;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode next;

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DLinkedNode> map = new HashMap<>();
    private int capacity;
    private DLinkedNode head, tail;

    // add node at head
    private void addToHead(DLinkedNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    // remove any node
    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode next = node.next;
        pre.next = next;
        next.pre = pre;
    }

    private DLinkedNode removeTail() {
        DLinkedNode node = tail.pre;
        removeNode(node);
        return node;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DLinkedNode(0, 0);
        tail = new DLinkedNode(0, 0);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        DLinkedNode node = map.get(key);
        removeNode(node);
        addToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            DLinkedNode node = new DLinkedNode(key, value);
            map.put(key, node);
            addToHead(node);
            if (map.size() > capacity) {
                DLinkedNode tail = removeTail();
                map.remove(tail.key);
            }
        }
        else {
            DLinkedNode node = map.get(key);
            node.value = value;
            removeNode(node);
            addToHead(node);
        }
    }
}

class LRUCacheII {
    Map<Integer, Integer> map;
    int capacity;

    public LRUCacheII(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>(capacity + 1);
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int val = map.get(key);
        map.remove(key); // reorder
        map.put(key, val);
        return val;
    }

    public void put(int key, int value) {
        map.remove(key); // reorder
        map.put(key, value);
        if (map.size() > capacity) {
            map.remove(map.entrySet().iterator().next().getKey());
        }
    }
}