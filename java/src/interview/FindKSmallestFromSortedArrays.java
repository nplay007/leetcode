package interview;

import java.util.List;
import java.util.PriorityQueue;

/*
 * 题目描述：从n sorted list找到median，可以拓展成从n sorted list里面找到第k个最小的
 *
 * 分析: time: O(klgn),  space: O(n)
 *
 * 思路：
 * 新建一个Object，里面存三个指针：arrIndex, index, value
 * 把每个arr第一个value的object放到min heap中
 * 每取出一个，把object对应的arr中下一个index的object放进heap，同时counter++
 * */
class Node {
    // arrIndex: 指向list中的哪个arr pointer
    // index: arr中指向int的pointer
    // value: arr[index]的value，用作建heap时比较
    int arrIndex, index, value;

    public Node(int arrIndex, int index, int value) {
        this.arrIndex = arrIndex;
        this.index = index;
        this.value = value;
    }
}

public class FindKSmallestFromSortedArrays {
    public static int findKSmallestFromNSortedArrays(List<int[]> list, int k) {
        PriorityQueue<Node> heap = new PriorityQueue<>((a, b) -> a.value - b.value);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null && list.get(i).length != 0) {
                heap.offer(new Node(i, 0, list.get(i)[0]));
            }
        }
        // 每次poll一个value然后offer这个value所在arr的下一个value
        int counter = 0;
        while (counter < k - 1) {
            if (heap.isEmpty())
                return -1;
            Node obj = heap.poll();
            if (obj.index < list.get(obj.arrIndex).length - 1) {
                heap.offer(new Node(obj.arrIndex, obj.index + 1, list.get(obj.arrIndex)[obj.index + 1]));
            }
            counter++;
        }
        return heap.poll().value;
    }
}
