package JavaAnswer.four;

public class Solution329 {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int[][] cache = new int[matrix.length][matrix[0].length];
        int result = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int len = dfs(i, j, matrix, cache);
                result = Math.max(result, len);
            }
        }
        return result;
    }

    public int dfs(int i, int j, int[][] matrix, int[][] cache) {
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        int result = 1;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] <= matrix[i][j]) {
                continue;
            }
            int len = 1 + dfs(x, y, matrix, cache);
            result = Math.max(result, len);
        }
        cache[i][j] = result;
        return result;
    }
}