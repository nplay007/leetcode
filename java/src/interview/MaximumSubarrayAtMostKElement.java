package interview;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumSubarrayAtMostKElement {
    // basically, my idea is maintain a deque to contains currently valid min value
    // valid means the min value must be in the scope of k from current i
    // Time: O(N)
    // Space: O(N)
    public int[] maxSubarrayAtMostK(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        // sum[i] represents the sum : nums[0] + ... nums[i - 1]
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        Deque<Integer> deque = new LinkedList<>();
        int max = 0;
        int[] candidate = null;
        for (int i = 0; i < sum.length; i++) {
            while (!deque.isEmpty() && sum[deque.peekLast()] >= sum[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            // out of scope
            if (deque.peekFirst() < i - k) {
                deque.pollFirst();
            }
            // if better subarray appear, update the result
            if (sum[i] - sum[deque.peekFirst()] > max) {
                max = sum[i] - sum[deque.peekFirst()];
                candidate = new int[] { deque.peekFirst(), i - 1 }; // inclusive idx
            }
        }
        // the left bound and right bound of the subarray of nums, both bound are inclusive.
        return candidate;
    }
}