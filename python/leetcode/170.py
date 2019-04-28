class TwoSum:
    def __init__(self):
        self.ctr = {}

    def add(self, num):
        self.ctr[num] = self.ctr.get(num, 0) + 1

    def find(self, value):
        ctr = self.ctr
        for num in ctr:
            if value - num in ctr and (value - num != num or ctr[num] > 1):
                return True
        return False