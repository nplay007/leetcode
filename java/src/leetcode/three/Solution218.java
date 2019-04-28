package JavaAnswer.three;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution218 {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for (int[] building : buildings) {
            // left side is negative, right is positive
            height.add(new int[] { building[0], -building[2] });
            height.add(new int[] { building[1], building[2] });
        }
        // 根据横坐标排序，相同横坐标的点纵坐标小的排在前面
        Collections.sort(height, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }
                else {
                    return a[1] - b[1];
                }
            }
        });
        // 构建堆，按照纵坐标来判断大小
        // Queue<Integer> queue = new PriorityQueue<>((a, b) -> b-a);
        Queue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });
        pq.offer(0);
        int prev = 0; // prev用于记录上次keypoint的高度
        for (int[] h : height) {
            if (h[1] < 0) {
                pq.offer(-h[1]);
            }
            else {
                pq.remove(h[1]);
            }
            int cur = pq.element();
            // 如果堆的新顶部和上个keypoint高度不一样，则加入一个新的keypoint
            if (prev != cur) {
                result.add(new int[] { h[0], cur });
                prev = cur;
            }
        }
        return result;
    }
}