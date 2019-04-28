package JavaAnswer.three;

import java.util.PriorityQueue;

public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] nums, int start, int end, int k) {
        if (start > end) {
            return -1;
        }
        int pivot = nums[end];
        int left = start;
        for (int i = start; i < end; i++) { // end has been used as pivot
            if (nums[i] <= pivot) {
                swap(nums, left++, i);
            }
        }
        swap(nums, left, end);
        if (left == k) {
            return nums[left];
        }
        else if (left < k) {
            return quickSelect(nums, left + 1, end, k);
        }
        else {
            return quickSelect(nums, start, left - 1, k);
        }
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

class Solution215PQ {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}