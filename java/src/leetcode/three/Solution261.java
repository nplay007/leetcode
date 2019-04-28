package JavaAnswer.three;

import java.util.ArrayList;
import java.util.List;

public class Solution261 {
    public boolean validTree(int n, int[][] edges) {
        int[] root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            while (x != root[x]) {
                x = root[x];
            }
            while (y != root[y]) {
                y = root[y];
            }
            if (root[x] == root[y]) {
                return false;
            }
            root[y] = x;
        }
        return edges.length == n - 1;
    }
}

class Solution261DFS {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        boolean[] visited = new boolean[n];
        // make sure there's no cycle
        if (hasCycle(0, -1, graph, visited)) {
            return false;
        }
        // make sure all vertices are connected
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    // check if an undirected graph has cycle started from vertex u
    boolean hasCycle(int i, int parent, List<List<Integer>> graph, boolean[] visited) {
        if (visited[i]) {
            return true;
        }
        visited[i] = true;
        for (int j = 0; j < graph.get(i).size(); j++) {
            int kid = graph.get(i).get(j);
            if (parent != kid && hasCycle(kid, i, graph, visited)) {
                return true;
            }
        }
        return false;
    }
}