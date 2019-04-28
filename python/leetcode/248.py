class Solution:
    def strobogrammaticInRange(self, low, high):
        self.res = 0
        self.find(low, high, "")
        self.find(low, high, "0")
        self.find(low, high, "1")
        self.find(low, high, "8")
        return self.res 

    def find(self, low, high, ch):
        m, n, l = len(low), len(high), len(ch)
        if m <= l <= n:
            if (m == l and ch < low) or (n == l and ch > high): return 
            if not (l > 1 and ch[0] == '0'): self.res += 1
        if l + 2 > n: return
        self.find(low, high, "0" + ch + "0")
        self.find(low, high, "1" + ch + "1")
        self.find(low, high, "6" + ch + "9")
        self.find(low, high, "8" + ch + "8")
        self.find(low, high, "9" + ch + "6")