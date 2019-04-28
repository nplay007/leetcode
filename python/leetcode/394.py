class Solution(object):
    def decodeString(self, s):
        stk, num = [], ""
        stk.append(["", 1])
        for ch in s:
            if ch.isdigit(): num += ch
            elif ch == "[":
                stk.append(["", int(num)])
                num = ""
            elif ch == "]":
                strs, k = stk.pop()
                stk[-1][0] += strs * k
            else: stk[-1][0] += ch
        return stk[0][0]