package JavaAnswer.one;

import java.util.Stack;

public class Solution084 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0, i = 0;
        while (i <= heights.length) { // we add a virtual node at end
            int h = (i == heights.length ? 0 : heights[i]);
            if (stack.empty() || h >= heights[stack.peek()]) {
                stack.push(i++); // increase index
            }
            else {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (stack.empty() ? i : i - 1 - stack.peek()));
            }
        }
        return maxArea;
    }
}