class Solution(object):
    def deserialize(self, s):
        stack = []
        num, sign = None, 1
        for c in s:
            if c == '-': sign = -1
            elif '0' <= c <= '9':
                num = (num or 0) * 10 + int(c)
            elif c == '[':
                stack.append(NestedInteger())
            else:
                if num is not None:
                    stack[-1].add(NestedInteger(num * sign))
                    num, sign = None, 1
                if c == ']':
                    top = stack.pop()
                    if stack: stack[-1].add(top)
                    else: return top
        return NestedInteger((num or 0) * sign)