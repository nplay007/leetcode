package JavaAnswer.three;

import java.util.Stack;

public class Solution255 {
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int num : preorder) {
            if (num < low) {
                return false;
            }
            while (!stack.isEmpty() && num > stack.peek()) {
                low = stack.pop();
            }
            stack.push(num);
        }
        return true;
    }
}