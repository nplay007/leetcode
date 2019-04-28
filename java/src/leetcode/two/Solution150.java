package JavaAnswer.two;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Solution150 {
    public int evalRPN(String[] tokens) {
        Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (operators.contains(token)) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(token.equals("+") ? num1 + num2 : token.equals("-") ? num2 - num1 : token.equals("*") ? num1 * num2 : num2 / num1);
            }
            else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }
}