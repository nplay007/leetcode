package JavaAnswer.seven;

public class Solution661 {
    public int[][] imageSmoother(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0][];
        }
        int m = matrix.length, n = matrix[0].length;
        int result[][] = new int[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                int count = 0, sum = 0;
                for (int dx : new int[] { -1, 0, 1 }) {
                    for (int dy : new int[] { -1, 0, 1 }) {
                        if (isValid(row + dx, col + dy, m, n)) {
                            count++;
                            sum += matrix[row + dx][col + dy];
                        }
                    }
                }
                result[row][col] = sum / count;
            }
        }
        return result;
    }

    private boolean isValid(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
