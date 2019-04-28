package interview;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class ItemInfo {
    public String name;
    public int value;
    public int maxStackSize;
}

class Pack {
    public int value;
    public int itemSize;

    Pack(int x, int y) {
        value = x;
        itemSize = y;
    }
}

public class MaxValuePackage {
    public static int maxValue(List<String> items, List<ItemInfo> itemInfos, int k) {
        int itemSize = itemInfos.size(); // total size of different kind of item
        Map<String, Integer> itemCount = new HashMap<>();
        Map<String, Integer> itemTable = new HashMap<>();
        for (int i = 0; i < itemSize; i++) {
            itemTable.put(itemInfos.get(i).name, i);
        }
        Queue<Pack> pq = new PriorityQueue<>((a, b) -> a.value * a.itemSize - b.value * b.itemSize);
        for (String item : items) {
            itemCount.put(item, itemCount.getOrDefault(item, 0) + 1);
            if (itemCount.get(item) == itemInfos.get(itemTable.get(item)).maxStackSize) {
                Pack tmp = new Pack(itemInfos.get(itemTable.get(item)).value, itemCount.get(item));
                pq.add(tmp);
                itemCount.put(item, 0);
            }
        }
        for (Map.Entry<String, Integer> entry : itemCount.entrySet()) {
            if (entry.getValue() > 0) {
                Pack tmp = new Pack(itemInfos.get(itemTable.get(entry.getKey())).value, entry.getValue());
                pq.add(tmp);
            }
        }
        int res = 0;
        for (int i = 0; i < k; i++) {
            Pack item = pq.poll();
            res += item.value * item.itemSize;
        }
        return res;
    }
}
