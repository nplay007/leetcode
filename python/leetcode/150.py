class Solution:
    def evalRPN(self, tokens):
        if not tokens:
            return 0
        stack = []
        for item in tokens:
            if item in '+-/*':
                n1, n2 = stack.pop(), stack.pop()
                if item == '+':
                    stack.append(n1 + n2)
                elif item == '-':
                    stack.append(n2 - n1)
                elif item == "*":
                    stack.append(n1 * n2)
                else:
                    stack.append(n2 / n1)
            else:
                stack.append(int(item))
        return stack.pop()
