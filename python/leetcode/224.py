class Solution:
    def calculate(self, s):
        total = 0
        i, signs = 0, [1, 1]
        while i < len(s):
            ch = s[i]
            if ch.isdigit():
                start = i
                while i < len(s) and s[i].isdigit():
                    i += 1
                total += signs.pop() * int(s[start:i])
                continue
            if ch in '+-(':
                signs += signs[-1] * (1, -1)[ch == '-'],
            elif ch == ')':
                signs.pop()
            i += 1
        return total
