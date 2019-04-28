class Solution(object):
    def read(self, buf, n):
        res = 0
        buffer = [''] * 4
        for i in xrange(n / 4 + 1):
            size = read4(buffer)
            if size == 0: break 
            buf[res:res+size] = buffer
            res += size
        return min(res, n)
