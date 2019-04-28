class Solution:
    def shortestPalindrome(self, s):
        T = s + "#" + s[::-1]
        p = [0] * len(T)
        for i in range(1, len(T)):
            j = p[i-1]
            while j > 0 and T[j] != T[i]:
                j = p[j-1]
            if T[i] == T[j]:
                p[i] = j + 1
        return s[p[-1]:][::-1] + s