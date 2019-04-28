package JavaAnswer.three;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses < 0 || prerequisites == null) {
            return new int[0];
        }
        List<Set<Integer>> graph = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] degrees = new int[numCourses];
        int[] result = new int[numCourses];
        // create graph
        for (int i = 0; i < numCourses; i++) {
            graph.add(new HashSet<>());
        }
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        // get the degrees
        for (int i = 0; i < numCourses; i++) {
            for (int j : graph.get(i)) {
                degrees[j]++;
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (degrees[i] == 0) {
                queue.add(i);
            }
        }
        // bfs the graph
        int count = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int i : graph.get(node)) {
                if (--degrees[i] == 0) {
                    queue.add(i);
                }
            }
            result[count++] = node;
        }
        // loop or not
        return count == numCourses ? result : new int[0];
    }
}

class Solution210DFS {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses < 0 || prerequisites == null) {
            return new int[0];
        }
        List<Set<Integer>> graph = new ArrayList<>();
        int[] visited = new int[numCourses];
        int[] result = new int[numCourses];
        Deque<Integer> order = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new HashSet<>());
        }
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, visited, order)) {
                return new int[0];
            }
        }
        for (int i = 0; !order.isEmpty(); i++) {
            result[i] = order.pop(); // remove from head
        }
        return result;
    }

    private boolean dfs(int i, List<Set<Integer>> graph, int[] visit, Deque<Integer> order) {
        if (visit[i] == 1) {
            return true;
        }
        else if (visit[i] == -1) {
            return false;
        }
        visit[i] = -1;
        for (int j : graph.get(i)) {
            if (!dfs(j, graph, visit, order)) {
                return false;
            }
        }
        visit[i] = 1;
        order.push(i); // add head
        return true;
    }
}
