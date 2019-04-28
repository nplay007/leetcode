class RandomizedCollection(object):
    def __init__(self):
        self.arr = []
        self.map = collections.defaultdict(set)

    def insert(self, val):
        self.map[val].add(len(self.arr))  # add val: index to dict
        self.arr.append(val)            # append val to list
        return len(self.map[val]) == 1

    def remove(self, val):
        if val not in self.map: return False
        idx, newVal = self.map[val].pop(), self.arr[-1] 
        # d[val].pop as set.pop, last element from d[val]
        # del d[val]'s index
        if len(self.map[val]) == 0: del self.map[val]
        self.arr[idx] = newVal  # overlap val in i
        if newVal in self.map:
            self.map[newVal].add(i)
            # s.discard(x) removes x from set s if present
            # remove the last idx, which is swap for val
            self.map[newVal].discard(len(self.arr)-1) 
        self.arr.pop() # remove val completely
        return True

    def getRandom(self):
        return random.choice(self.arr)  # same as self.arr[randint(0, n-1)]