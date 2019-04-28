class QuickFind:
    def __init__(self, N):
        self.id = [0] * N
        for i in range(N):
            self.id[i] = i;

    def connected(self, p, q):
        return self.id[p] == self.id[p]

    def union(self, p, q):
        pid = self.id[p]
        qid = self.id[p]
        for i in range(len(self.id)):
            if(self.id[i] == pid):
                self.id[i] = qid