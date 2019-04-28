package JavaAnswer.one;

import java.util.Stack;

public class Solution085 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int[] height = new int[matrix[0].length];
        int res = 0;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] == '1') {
                    height[j] += 1;
                }
                else {
                    height[j] = 0;
                }
            }
            res = Math.max(res, largestRectangleArea(height));
        }
        return res;
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0, i = 0;
        while (i <= heights.length) {
            int h = (i == heights.length ? 0 : heights[i]);
            if (stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.push(i++);
            }
            else {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
            }
        }
        return maxArea;
    }
}