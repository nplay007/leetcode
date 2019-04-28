class Solution:
    def findRepeatedDnaSequences(self, s):
        d, res = {}, []
        for i in range(len(s)-9):
            ch = s[i:i+10]
            d[ch] = d.get(ch, 0) + 1
        for keys, value in d.iteritems():
            if value > 1: res.append(keys)
        return res