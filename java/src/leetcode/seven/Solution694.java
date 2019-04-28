package JavaAnswer.seven;

import java.util.HashSet;
import java.util.Set;

public class Solution694 {
    int[][] grid;
    boolean[][] visited;
    Set<Integer> shape;

    public void dfs(int i, int j, int x, int y) {
        if (0 <= i && i < grid.length && 0 <= j && j < grid[0].length && grid[i][j] == 1 && !visited[i][j]) {
            visited[i][j] = true;
            shape.add((i - x) * 2 * grid[0].length + (j - y)); // convert (i, j) -> integer
            dfs(i + 1, j, x, y);
            dfs(i - 1, j, x, y);
            dfs(i, j + 1, x, y);
            dfs(i, j - 1, x, y);
        }
    }

    public int numDistinctIslands(int[][] grid) {
        this.grid = grid;
        visited = new boolean[grid.length][grid[0].length];
        Set<Set<Integer>> shapes = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                shape = new HashSet<>();
                dfs(i, j, i, j);
                if (!shape.isEmpty()) {
                    shapes.add(shape);
                }
            }
        }
        return shapes.size();
    }
}
