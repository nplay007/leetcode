class Solution(object):
    def generatePossibleNextMoves(self, s):
        n, res = len(s), []
        for i in range(n - 1):
            if s[i:i+2] == '++':
                res.append(s[:i] + '--' + s[i+2:])
        return res