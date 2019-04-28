package JavaAnswer.three;

import java.util.LinkedList;
import java.util.List;

public class Solution241 {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (Integer num1 : left) {
                    for (Integer num2 : right) {
                        int compute = ch == '+' ? num1 + num2 : ch == '-' ? num1 - num2 : num1 * num2;
                        result.add(compute);
                    }
                }
            }
        }
        if (result.size() == 0) {
            result.add(Integer.valueOf(input));
        }
        return result;
    }
}