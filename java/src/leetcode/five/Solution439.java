package JavaAnswer.five;

import java.util.Stack;

public class Solution439 {
    public String parseTernary(String expression) {
        if (expression == null || expression.length() == 0) {
            return "";
        }
        Stack<Character> stack = new Stack<>();
        for (int i = expression.length() - 1; i >= 0; i--) {
            char ch = expression.charAt(i);
            if (!stack.isEmpty() && stack.peek() == '?') {
                stack.pop(); // pop '?'
                char first = stack.pop();
                stack.pop(); // pop ':'
                char second = stack.pop();
                if (ch == 'T') {
                    stack.push(first);
                }
                else {
                    stack.push(second);
                }
            }
            else {
                stack.push(ch);
            }
        }
        return String.valueOf(stack.peek());
    }
}
