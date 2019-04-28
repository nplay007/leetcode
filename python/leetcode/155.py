class MinStack:
    def __init__(self):
        self.stack1 = []
        self.stack2 = []

    def push(self, x):
        self.stack1.append(x)
        if not self.stack2 or x <= self.stack2[-1]:
            self.stack2.append(x)

    def pop(self):
        top = self.stack1.pop()
        if top == self.stack2[-1]:
            self.stack2.pop()

    def top(self):
        return self.stack1[-1]

    def getMin(self):
        return self.stack2[-1]
