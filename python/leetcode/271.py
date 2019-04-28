class Codec:
    def encode(self, strs):
        res = ""
        for s in strs:
            res += str(len(s)) + '#' + s
        return res

    def decode(self, s):
        i, res = 0, []
        while i < len(s):
            idx = s.find('#', i)
            size = int(s[i:idx])
            res.append(s[idx+1:idx+1+size])
            i = idx + size + 1
        return res