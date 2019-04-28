package JavaAnswer.four;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Set<Integer>> graph = new ArrayList<>(n);
        List<Integer> leaves = new ArrayList<>();
        if (n == 1) { // handle this
            leaves.add(0);
            return leaves;
        }
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<Integer>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int leave : leaves) {
                int j = graph.get(leave).iterator().next(); // only one
                graph.get(j).remove(leave);
                if (graph.get(j).size() == 1) {
                    newLeaves.add(j);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}