package JavaAnswer.one;

import java.util.Stack;

public class Solution032 {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int last = -1, res = 0; // last = -1 is necessary for '()'
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            else {
                if (stack.empty()) {
                    last = i; // update the last valid position
                }
                else {
                    stack.pop();
                    res = stack.empty() ? Math.max(res, i - last) : Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }
}