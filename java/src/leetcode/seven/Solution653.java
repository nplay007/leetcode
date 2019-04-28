package JavaAnswer.seven;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import JavaAnswer.TreeNode;

public class Solution653 {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        if (nums.size() < 2) {
            return false;
        }
        int left = 0, right = nums.size() - 1;
        while (left < right) {
            if (nums.get(left) + nums.get(right) == k) {
                return true;
            }
            else if (nums.get(left) + nums.get(right) > k) {
                right--;
            }
            else {
                left++;
            }
        }
        return false;
    }

    private void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }
}

class Solution653II {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return find(root, k, set);
    }

    public boolean find(TreeNode root, int k, Set<Integer> set) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }
}

class Solution653III {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                if (set.contains(k - node.val)) {
                    return true;
                }
                set.add(node.val);
                queue.add(node.right);
                queue.add(node.left);
            }
        }
        return false;
    }
}
