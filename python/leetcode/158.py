class Solution(object):
    def __init__(self):
        self.readpos = 0
        self.writepos = 0
        self.buffer = [' '] * 4
        
    def read(self, buf, n):
        for i in range(n):
            if self.writepos == self.readpos:
                self.writepos = read4(self.buffer)
                self.readpos = 0
                if self.writepos == 0: return i
            buf[i] = self.buffer[self.readpos]
            self.readpos += 1
        return n