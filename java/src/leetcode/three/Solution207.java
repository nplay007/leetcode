package JavaAnswer.three;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Set<Integer>> graph = new ArrayList<>();
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new HashSet<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, visited, graph)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int i, int[] visited, List<Set<Integer>> graph) {
        if (visited[i] == 1) {
            return true;
        }
        else if (visited[i] == -1) {
            return false;
        }
        visited[i] = -1;
        for (int j : graph.get(i)) {
            if (!dfs(j, visited, graph)) {
                return false;
            }
        }
        visited[i] = 1;
        return true;
    }
}

class Solution207BFS {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Set<Integer>> graph = new ArrayList<>();
        int[] degrees = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new HashSet<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for (int i = 0; i < numCourses; i++) {
            for (int neigh : graph.get(i)) {
                degrees[neigh]++;
            }
        }
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degrees[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;
            for (int neigh : graph.get(node)) {
                if (--degrees[neigh] == 0) {
                    queue.add(neigh);
                }
            }
        }
        return count == numCourses;
    }
}