package JavaAnswer.two;

import java.util.Stack;

public class Solution155 {
}

class MinStack {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MinStack() {
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int x) {
        stackData.push(x);
        if (stackMin.isEmpty() || x <= stackMin.peek()) {
            stackMin.push(x);
        }
    }

    public void pop() {
        int x = stackData.pop();
        if (x == stackMin.peek()) {
            stackMin.pop();
        }
    }

    public int top() {
        return stackData.peek();
    }

    public int getMin() {
        return stackMin.peek();
    }
}
