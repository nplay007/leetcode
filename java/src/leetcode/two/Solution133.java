package JavaAnswer.two;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import JavaAnswer.UndirectedGraphNode;

public class Solution133 {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode root) {
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        return dfs(root, map);
    }

    private UndirectedGraphNode dfs(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        map.put(node.label, copy);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            copy.neighbors.add(dfs(neighbor, map));
        }
        return copy;
    }
}

class Solution133BFS {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode root) {
        if (root == null) {
            return null;
        }
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        UndirectedGraphNode copy = new UndirectedGraphNode(root.label);
        map.put(root.label, copy);
        queue.add(root);

        while (!queue.isEmpty()) {
            UndirectedGraphNode node = queue.poll();
            for (UndirectedGraphNode neighbor : node.neighbors) {
                if (!map.containsKey(neighbor.label)) {
                    map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                    queue.add(neighbor);
                }
                map.get(node.label).neighbors.add(map.get(neighbor.label));
            }
        }
        return copy;
    }
}