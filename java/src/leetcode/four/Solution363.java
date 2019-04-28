package JavaAnswer.four;

import java.util.TreeSet;

public class Solution363 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int result = Integer.MIN_VALUE;
        for (int left = 0; left < matrix[0].length; left++) {
            int[] sums = new int[matrix.length];
            for (int right = left; right < matrix[0].length; right++) {
                for (int i = 0; i < matrix.length; i++) {
                    sums[i] += matrix[i][right];
                }
                TreeSet<Integer> set = new TreeSet<Integer>();
                set.add(0);
                int currSum = 0;
                for (int sum : sums) {
                    currSum += sum;
                    Integer num = set.ceiling(currSum - k);
                    if (num != null) {
                        result = Math.max(result, currSum - num);
                    }
                    set.add(currSum);
                }
            }
        }
        return result;
    }
}