class Queue(object):
    def __init__(self):
        self.stk = []

    def push(self, x):
        if not self.stk: self.stk.append(x)
        else:
            data = self.stk.pop()
            self.push(x)
            self.stk.append(data)

    def pop(self):
        self.stk.pop()

    def peek(self):
        return self.stk[-1]

    def empty(self):
        return not self.stk

