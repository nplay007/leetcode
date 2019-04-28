package JavaAnswer.one;

public class Solution074 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int left = 0, right = matrix.length * matrix[0].length - 1;
        while (left <= right) {
            int m = (right - left) / 2 + left;
            int x = m / matrix[0].length;
            int y = m % matrix[0].length;
            if (matrix[x][y] == target) {
                return true;
            }
            else if (matrix[x][y] > target) {
                right = m - 1;
            }
            else {
                left = m + 1;
            }
        }
        return false;
    }
}