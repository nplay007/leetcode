class Solution(object):
    def convert(self, s, numRows):
        if numRows == 1:
            return s
        strs = [""] * numRows
        for i, ch in enumerate(s):
            idx = i % (2 * numRows - 2)
            j = idx if idx < numRows else 2 * numRows - 2 - idx
            strs[j] += ch
        return "".join(strs)