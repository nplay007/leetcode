package JavaAnswer.three;

import java.util.Stack;

public class Solution224 {
    public int calculate(String s) {
        Stack<Integer> signs = new Stack<>();
        signs.push(1);
        signs.push(1);
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = 10 * num + s.charAt(i++) - '0';
                }
                result += signs.pop() * num;
                i--;
            }
            else if (ch == ')') {
                signs.pop();
            }
            else if (ch != ' ') {
                signs.push(signs.peek() * (ch == '-' ? -1 : 1));
            }
        }
        return result;
    }
}

class Solution224II {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0, num = 0, sign = 1;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = 10 * num + ch - '0';
            }
            else if (ch == '+') {
                result += sign * num;
                num = 0;
                sign = 1;
            }
            else if (ch == '-') {
                result += sign * num;
                num = 0;
                sign = -1;
            }
            else if (ch == '(') {
                // we push the result first, then sign;
                stack.push(result);
                stack.push(sign);
                // reset the sign and result for the value in the parenthesis
                sign = 1;
                result = 0;
            }
            else if (ch == ')') {
                result += sign * num;
                num = 0;
                result *= stack.pop(); // stack.pop() is the sign before the parenthesis
                result += stack.pop(); // stack.pop() now is the result calculated before the parenthesis

            }
        }
        if (num != 0) {
            result += sign * num;
        }
        return result;
    }
}