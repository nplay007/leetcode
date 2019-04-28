package JavaAnswer.five;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution417 {
    int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int m = matrix.length, n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();
        for (int i = 0; i < m; i++) { // Vertical border
            pQueue.offer(new int[] { i, 0 });
            aQueue.offer(new int[] { i, n - 1 });
            pacific[i][0] = true;
            atlantic[i][n - 1] = true;
        }
        for (int i = 0; i < n; i++) { // Horizontal border
            pQueue.offer(new int[] { 0, i });
            aQueue.offer(new int[] { m - 1, i });
            pacific[0][i] = true;
            atlantic[m - 1][i] = true;
        }
        bfs(matrix, pQueue, pacific);
        bfs(matrix, aQueue, atlantic);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j])
                    res.add(new int[] { i, j });
            }
        }
        return res;
    }

    public void bfs(int[][] matrix, Queue<int[]> queue, boolean[][] visited) {
        int m = matrix.length, n = matrix[0].length;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : dirs) {
                int i = cur[0] + dir[0];
                int j = cur[1] + dir[1];
                if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || matrix[i][j] < matrix[cur[0]][cur[1]]) {
                    continue;
                }
                visited[i][j] = true;
                queue.offer(new int[] { i, j });
            }
        }
    }
}

class Solution417dfs {
    private static final int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int n = matrix.length, m = matrix[0].length;
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
            dfs(matrix, atlantic, Integer.MIN_VALUE, i, m - 1);
        }
        for (int i = 0; i < m; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
            dfs(matrix, atlantic, Integer.MIN_VALUE, n - 1, i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(new int[] { i, j });
                }
            }
        }
        return res;
    }

    public void dfs(int[][] matrix, boolean[][] visited, int height, int x, int y) {
        int m = matrix.length, n = matrix[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || matrix[x][y] < height) {
            return;
        }
        visited[x][y] = true;
        for (int[] dir : dirs) {
            dfs(matrix, visited, matrix[x][y], x + dir[0], y + dir[1]);
        }
    }
}
