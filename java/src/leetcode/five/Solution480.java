package JavaAnswer.five;

import java.util.Collections;
import java.util.TreeMap;

public class Solution480 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> minHeap = new TreeMap<>();
        TreeMap<Integer, Integer> maxHeap = new TreeMap<>(Collections.reverseOrder());
        double[] result = new double[nums.length - k + 1];
        int i = 0, numToRemove = 0;
        int minSize = 0, maxSize = 0;
        for (int num : nums) {
            if (i > k - 1) {
                numToRemove = nums[i - k];
            }
            Double maxHeapTop = maxHeap.firstEntry() != null ? (double) maxHeap.firstKey() : Double.MAX_VALUE;

            if (num < maxHeapTop) {
                maxHeap.put(num, maxHeap.getOrDefault(num, 0) + 1);
                maxSize++;
            }
            else {
                minHeap.put(num, minHeap.getOrDefault(num, 0) + 1);
                minSize++;
            }

            TreeMap<Integer, Integer> pq = null;
            if (minHeap.firstEntry() == null) {
                pq = maxHeap;
            }
            else {
                pq = numToRemove >= minHeap.firstKey() ? minHeap : maxHeap;
            }

            if (i >= k && pq.containsKey(numToRemove)) {
                if (pq == minHeap) {
                    minSize--;
                }
                else {
                    maxSize--;
                }
                if (pq.get(numToRemove) == 1) {
                    pq.remove(numToRemove);
                }
                else {
                    pq.put(numToRemove, pq.get(numToRemove) - 1);
                }
            }

            if (minSize - 1 > maxSize) {
                transferFrom(minHeap, maxHeap);
                minSize--;
                maxSize++;
            }
            else if (minSize < maxSize - 1) {
                transferFrom(maxHeap, minHeap);
                maxSize--;
                minSize++;
            }

            if (i >= k - 1 && minSize == maxSize) {
                result[i - k + 1] = ((double) minHeap.firstKey() + (double) maxHeap.firstKey()) / 2.0;
            }
            else if (i >= k - 1 && minSize > maxSize) {
                result[i - k + 1] = minHeap.firstKey();
            }
            else if (i >= k - 1) {
                result[i - k + 1] = maxHeap.firstKey();
            }
            i++;
        }
        return result;
    }

    public void transferFrom(TreeMap<Integer, Integer> src, TreeMap<Integer, Integer> dest) {
        dest.put(src.firstKey(), dest.getOrDefault(src.firstKey(), 0) + 1);
        if (src.firstEntry().getValue() == 1) {
            src.remove(src.firstKey());
        }
        else {
            src.put(src.firstKey(), src.firstEntry().getValue() - 1);
        }
    }
}