package JavaAnswer.seven;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import JavaAnswer.TreeNode;

public class Solution652 {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new LinkedList<>();
        postorder(root, new HashMap<>(), result);
        return result;
    }

    public String postorder(TreeNode root, Map<String, Integer> map, List<TreeNode> result) {
        if (root == null) {
            return "#";
        }
        String path = root.val + "," + postorder(root.left, map, result) + "," + postorder(root.right, map, result);
        if (map.getOrDefault(path, 0) == 1) {
            result.add(root);
        }
        map.put(path, map.getOrDefault(path, 0) + 1);
        return path;
    }
}