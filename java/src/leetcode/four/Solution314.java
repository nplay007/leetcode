package JavaAnswer.four;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

import JavaAnswer.TreeNode;

public class Solution314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        // column : list of nodes
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        // correspondent column
        Queue<Integer> column = new LinkedList<>();
        queue.add(root);
        column.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int col = column.poll();
                if (!map.containsKey(col)) {
                    map.put(col, new ArrayList<>());
                }
                map.get(col).add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                    column.add(col - 1);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    column.add(col + 1);
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (Entry<Integer, List<Integer>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}

class Solution314II {
    class TreeNodeColumn {
        public TreeNode node;
        public int column;

        public TreeNodeColumn(TreeNode node, int column) {
            this.node = node;
            this.column = column;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNodeColumn> queue = new LinkedList<>();
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        queue.add(new TreeNodeColumn(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNodeColumn top = queue.poll();
                if (!map.containsKey(top.column)) {
                    map.put(top.column, new ArrayList<>());
                }
                map.get(top.column).add(top.node.val);
                if (top.node.left != null) {
                    queue.add(new TreeNodeColumn(top.node.left, top.column - 1));
                }
                if (top.node.right != null) {
                    queue.add(new TreeNodeColumn(top.node.right, top.column + 1));
                }
            }
        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}