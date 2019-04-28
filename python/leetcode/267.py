class Solution(object):
    def generatePalindromes(self, s):
        res = []
        t, mid = [], []
        words = collections.defaultdict(int)
        for ch in s: words[ch] += 1
        for key, val in words.iteritems():
            if val % 2 == 1: mid.append(key)
            if len(mid) > 1: return []
            t.extend(list(key * (val/2)))
        self.permute(t, 0, mid, res)
        return res

    def permute(self, t, start, mid, res):
        if start >= len(t):
            res.append("".join(t + mid + t[::-1]))
            return 
        for i in range(start, len(t)):
            if i != start and t[i] == t[start]: continue
            t[i], t[start] = t[start], t[i]
            self.permute(t, start + 1, mid, res)
            t[i], t[start] = t[start], t[i]