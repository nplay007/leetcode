class HitCounter(object):
    def __init__(self):
        from collections import deque
        self.cnts = 0
        self.hits = deque()

    def hit(self, timestamp):
        if not self.hits or self.hits[-1][0] != timestamp:
            self.hits.append([timestamp, 1])
        else:
            self.hits[-1][1] += 1
        self.cnts += 1

    def getHits(self, timestamp):
        while self.hits and self.hits[0][0] <= timestamp - 300:
            self.cnts -= self.hits.popleft()[1]
        return self.cnts