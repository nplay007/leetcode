package JavaAnswer.three;

public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int j = matrix[0].length - 1, i = 0;
        while (j >= 0 && i < matrix.length) {
            if (target == matrix[i][j]) {
                return true;
            }
            else if (target < matrix[i][j]) {
                j--; // j only decrease since it start at maximum number
            }
            else if (target > matrix[i][j]) {
                i++;
            }
        }
        return false;
    }
}