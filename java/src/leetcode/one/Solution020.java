package JavaAnswer.one;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution020 {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(')');
            }
            else if (ch == '{') {
                stack.push('}');
            }
            else if (ch == '[') {
                stack.push(']');
            }
            else if (stack.isEmpty() || stack.pop() != ch) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}