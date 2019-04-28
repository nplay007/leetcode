class Stack:
    def __init__(self):
        self.stack = collections.deque([])

    def push(self, x):
        self.stack.append(x)

    def pop(self):
        for i in range(len(self.stack) - 1):
            self.stack.append(self.stack.popleft())
        self.stack.popleft()

    def top(self):
        return self.stack[-1]

    def empty(self):
        return len(self.stack) == 0