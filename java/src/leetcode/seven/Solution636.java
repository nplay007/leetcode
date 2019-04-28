package JavaAnswer.seven;

import java.util.List;
import java.util.Stack;

public class Solution636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        String[] s = logs.get(0).split(":");
        stack.push(Integer.parseInt(s[0])); // id
        int prev = Integer.parseInt(s[2]); // start time
        for (int i = 1; i < logs.size(); i++) {
            s = logs.get(i).split(":");
            if (s[1].equals("start")) {
                if (!stack.isEmpty()) {
                    result[stack.peek()] += Integer.parseInt(s[2]) - prev;
                }
                stack.push(Integer.parseInt(s[0]));
                prev = Integer.parseInt(s[2]);
            }
            else {
                result[stack.peek()] += Integer.parseInt(s[2]) - prev + 1;
                stack.pop();
                prev = Integer.parseInt(s[2]) + 1;
            }
        }
        return result;
    }
}
