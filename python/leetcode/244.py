class WordDistance(object):
    def __init__(self, words):
        self.d = collections.defaultdict(list)
        for i, word in enumerate(words):
            self.d[word].append(i)

    def shortest(self, w1, w2):
        d1, d2 = self.d[w1], self.d[w2]
        m, n, i, j, res = len(d1), len(d2), 0, 0, 2**31
        while i < m and j < n:
            res = min(res, abs(d1[i] - d2[j]))
            if d1[i] < d2[j]: i += 1
            else: j += 1
        return res