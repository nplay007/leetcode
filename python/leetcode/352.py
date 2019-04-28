# Definition for an interval.
class Interval(object):
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e

class SummaryRanges(object):
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.intervals = []

    def addNum(self, val):
        """
        :type val: int
        :rtype: void
        """
        newInterval = Interval(val, val)
        self.insertIntervals(newInterval)

    def getIntervals(self):
        """
        :rtype: List[Interval]
        """
        return [i for i in self.intervals]

    def insertIntervals(self, newInterval):
        s, e = newInterval.start, newInterval.end
        left = [item for item in self.intervals if item.end < s - 1]
        right = [item for item in self.intervals if item.start > e + 1]
        if left + right != self.intervals:
            s = min(s, self.intervals[len(left)].start)
            e = max(e, self.intervals[~len(right)].end)  # ~len(right) = - len(right) - 1
        self.intervals = left + [Interval(s, e)] + right

    def printInterval(self, res):
        for item in res:
            print [item.start, item.end],
        print "\n"


if __name__ == "__main__":
    test = SummaryRanges()
    test.addNum(1)
    res = test.getIntervals()
    test.printInterval(res)
    test.addNum(3)
    res = test.getIntervals()
    test.printInterval(res)
    test.addNum(7)
    res = test.getIntervals()
    test.printInterval(res)
    test.addNum(2)
    res = test.getIntervals()
    test.printInterval(res)
    test.addNum(6)
    res = test.getIntervals()
    test.printInterval(res)
