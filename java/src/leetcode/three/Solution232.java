package JavaAnswer.three;

import java.util.Stack;

class MyQueue {
    Stack<Integer> stack;

    public MyQueue() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.empty()) {
            stack.push(x);
        }
        else {
            int data = stack.pop();
            push(x);
            stack.push(data);
        }
    }

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.empty();
    }
}
