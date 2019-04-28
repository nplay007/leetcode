from heapq import heappop, heappush, heappushpop
class MedianFinder:
    def __init__(self):
        self.small = []  # the smaller part, min heap with negative values
        self.large = []  # the larger part, min heap

    def addNum(self, num):
        if len(self.small) == len(self.large): # add number into large heap
            # put new number in small heap and get the largest number
            # push the largest number for small heap into large heap
            # so we need put negative value into small heap
            heappush(self.large, -heappushpop(self.small, -num))
        else: # add number into small heap
            heappush(self.small, -heappushpop(self.large, num))

    def findMedian(self):
        if len(self.small) == len(self.large):
            return float(self.large[0] - self.small[0]) / 2.0
        else:
            return float(self.large[0])