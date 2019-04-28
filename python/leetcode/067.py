class Solution:
    def addBinary(self, a, b):
        i, j, carry, res = len(a) - 1, len(b) - 1, 0, ""
        while i > -1 or j > -1:
            num1 = ord(a[i]) - ord("0") if i > -1 else 0
            num2 = ord(b[j]) - ord("0") if j > -1 else 0
            i -= 1
            j -= 1
            res = str((carry + num1 + num2) % 2) + res
            carry = (carry + num1 + num2) / 2
        if carry > 0:
            res = str(carry) + res
        return res
