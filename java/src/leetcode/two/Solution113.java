package JavaAnswer.two;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import JavaAnswer.TreeNode;

public class Solution113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        pathSum(root, sum, new LinkedList<>(), res);
        return res;
    }

    public void pathSum(TreeNode root, int sum, List<Integer> ans, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            res.add(ans);
        }
        pathSum(root.left, sum - root.val, ans, res);
        pathSum(root.right, sum - root.val, ans, res);
        ans.remove(ans.size() - 1);
    }
}

class Solution113Recrusion {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int curSum = 0;
        TreeNode last = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                ans.add(root.val);
                curSum += root.val;
                root = root.left;
            }
            root = stack.peek();
            if (root.left == null && root.right == null && curSum == sum) {
                res.add(new ArrayList<Integer>(ans));
            }
            if (root.right == null || root.right == last) {
                last = root;
                stack.pop();
                ans.remove(ans.size() - 1);
                curSum -= root.val;
                root = null;

            }
            else {
                root = root.right;
            }
        }
        return res;
    }
}