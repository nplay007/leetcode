import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

class FrequencyNode {
    public int value;
    public LinkedHashSet<Integer> items;
    public FrequencyNode prev;
    public FrequencyNode next;

    public FrequencyNode(int value) {
        this.value = value;
        items = new LinkedHashSet<>();
    }
}

class LFUNode {
    public int value;
    public FrequencyNode parent;

    public LFUNode(int value, FrequencyNode parent) {
        this.value = value;
        this.parent = parent;
    }
}

public class LFUCache {
    FrequencyNode head;
    Map<Integer, LFUNode> map;

    public LFUCache() {
        map = new HashMap<>();
    }

    public FrequencyNode getNewNode(int value, FrequencyNode prev, FrequencyNode next) {
        FrequencyNode node = new FrequencyNode(value);
        node.prev = prev;
        node.next = next;
        prev.next = node;
        next.prev = node;
        return node;
    }

    public void deleteNode(FrequencyNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            throw new IllegalArgumentException("no such key");
        }
        LFUNode node = map.get(key);
        FrequencyNode freq = node.parent;
        FrequencyNode nextFreq = freq.next;

        if (nextFreq == head || nextFreq.value != freq.value + 1) {
            nextFreq = getNewNode(freq.value + 1, freq, nextFreq);
        }
        nextFreq.items.add(key);
        node.parent = nextFreq;
        freq.items.remove(key);
        if (freq.items.size() == 0) {
            deleteNode(freq);
        }
        return node.value;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {

        }
    }
}
