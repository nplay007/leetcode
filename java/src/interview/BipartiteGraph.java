package interview;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

//  BFS: time: O(mn), space: O(mn)
public class BipartiteGraph {
    public boolean isBipartite(int graph[][], int src) {
        if (graph == null || graph.length == 0) {
            return true;
        }
        // value 1 indicates first colour is assigned
        // value 0 indicates second colour is assigned.
        int color[] = new int[graph.length];
        Arrays.fill(color, -1);
        color[src] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            // Find all non-colored adjacent vertices
            for (int v = 0; v < graph.length; ++v) {
                if (graph[u][v] == 1 && color[v] == -1) {
                    color[v] = 1 - color[u];
                    queue.add(v);
                }
                else if (graph[u][v] == 1 && color[v] == color[u]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartite(List<Set<Integer>> graph, int src) {
        if (graph == null || graph.size() == 0) {
            return true;
        }
        // value 1 indicates first colour is assigned
        // value 0 indicates second colour is assigned.
        int color[] = new int[graph.size()];
        Arrays.fill(color, -1);
        color[src] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            // Find all non-colored adjacent vertices
            for (int v : graph.get(u)) {
                if (color[v] == -1) {
                    color[v] = 1 - color[u];
                    queue.add(v);
                }
                else if (color[v] == color[u]) {
                    return false;
                }
            }
        }
        return true;
    }
}
