package JavaAnswer.one;

public class Solution059 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int left = 0, top = 0, right = n - 1, bottom = n - 1, cnts = 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = cnts++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = cnts++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = cnts++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = cnts++;
            }
            left++;
        }
        return matrix;
    }
}