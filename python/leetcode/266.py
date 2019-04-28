class Solution:
    def canPermutePalindrome(self, s):
        res = {}
        for item in s:
            if item not in res: res[item] += 1
            else: res.pop(item)
        return len(res) < 2

    def canPermutePalindrome(self, s):
        import collections
        d = collections.Counter(s)
        m = tuple(k for k, v in d.iteritems() if v % 2)
        return len(m) < 2