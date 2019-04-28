package JavaAnswer.four;

import java.util.Arrays;
import java.util.List;

public class Solution315 {
    class Node {
        Node left, right;
        int val, count, dup = 1;

        public Node(int val, int sum) {
            this.val = val;
            this.count = sum;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(nums[i], root, ans, i, 0);
        }
        return Arrays.asList(ans);
    }

    private Node insert(int num, Node node, Integer[] ans, int i, int preSum) {
        if (node == null) {
            node = new Node(num, 0);
            ans[i] = preSum;
        }
        else if (node.val == num) {
            node.dup++;
            ans[i] = preSum + node.count;
        }
        else if (node.val > num) {
            node.count++;
            node.left = insert(num, node.left, ans, i, preSum);
        }
        else {
            node.right = insert(num, node.right, ans, i, preSum + node.dup + node.count);
        }
        return node;
    }
}