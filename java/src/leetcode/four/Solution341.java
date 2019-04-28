package JavaAnswer.four;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

import JavaAnswer.NestedInteger;

class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> stack = new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger curr = stack.peek();
            if (curr.isInteger()) {
                return true;
            }
            stack.pop();
            for (int i = curr.getList().size() - 1; i >= 0; i--) {
                stack.push(curr.getList().get(i));
            }
        }
        return false;
    }
}

class NestedIteratorII implements Iterator<Integer> {
    private Stack<ListIterator<NestedInteger>> stack;

    public NestedIteratorII(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        stack.push(nestedList.listIterator());
    }

    @Override
    public Integer next() {
        hasNext();
        return stack.peek().next().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.empty()) {
            if (!stack.peek().hasNext()) {
                stack.pop();
            }
            else {
                NestedInteger nestedInteger = stack.peek().next();
                if (nestedInteger.isInteger()) {
                    return stack.peek().previous() == nestedInteger;
                }
                stack.push(nestedInteger.getList().listIterator());
            }
        }
        return false;
    }
}