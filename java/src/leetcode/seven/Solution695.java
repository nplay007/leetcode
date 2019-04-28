package JavaAnswer.seven;

import java.util.LinkedList;
import java.util.Queue;

public class Solution695 {
    public int dfs(int i, int j, int[][] grid, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == 0) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(i + 1, j, grid, visited) + dfs(i - 1, j, grid, visited) + dfs(i, j - 1, grid, visited) + dfs(i, j + 1, grid, visited);
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                result = Math.max(result, dfs(i, j, grid, visited));
            }
        }
        return result;
    }
}

class Solution695II {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int shape = 0;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[] { i, j });
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        int[] node = queue.poll();
                        shape++;
                        for (int[] dir : dirs) {
                            int x = node[0] + dir[0];
                            int y = node[1] + dir[1];
                            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0 || visited[x][y]) {
                                continue;
                            }
                            queue.add(new int[] { x, y });
                            visited[x][y] = true;
                        }
                    }
                    result = Math.max(result, shape);
                }
            }
        }
        return result;
    }
}