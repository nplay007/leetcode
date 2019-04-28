class Solution:
    def resValidParentheses(self, s):
        maxlen, stack, last = 0, [], -1
        for i in range(len(s)):
            if s[i] == '(':
                stack.append(i)
            else:
                if not stack:
                    last = i  # ')' is more than '('
                else:
                    stack.pop()
                    if not stack:
                        maxlen = max(maxlen, i - last)
                    else:
                        maxlen = max(maxlen, i - stack[-1])
        return maxlen
