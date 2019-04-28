package JavaAnswer.five;

import java.util.HashMap;
import java.util.Map;

import JavaAnswer.TreeNode;

public class Solution437 {
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return dfs(root, 0, sum, map);
    }

    public int dfs(TreeNode root, int cur, int target, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        cur += root.val;
        int res = map.getOrDefault(cur - target, 0);
        map.put(cur, map.getOrDefault(cur, 0) + 1);
        res += dfs(root.left, cur, target, map) + dfs(root.right, cur, target, map);
        map.put(cur, map.get(cur) - 1);
        return res;
    }
}
