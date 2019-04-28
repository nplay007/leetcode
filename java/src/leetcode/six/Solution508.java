package JavaAnswer.six;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import JavaAnswer.TreeNode;

public class Solution508 {
    private int maxCount;

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        postOrder(root, map);
        List<Integer> nodes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxCount) {
                nodes.add(entry.getKey());
            }
        }
        int[] result = new int[nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            result[i] = nodes.get(i);
        }
        return result;
    }

    private int postOrder(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        int left = postOrder(root.left, map);
        int right = postOrder(root.right, map);
        int sum = left + right + root.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        if (map.get(sum) > maxCount) {
            maxCount = map.get(sum);
        }
        return sum;
    }
}