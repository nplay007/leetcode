class Solution(object):
    def topKFrequent(self, nums, k):
        from collections import Counter
        d, res, l = Counter(nums), [], []
        for val in d.itervalues():
            l.append(val)
        l.sort(reverse=True)
        num = l[k-1]
        for key, val in d.iteritems():
            if val >= num: res.append(key)
        return res

# return zip(*collections.Counter(nums).most_common(k))[0]
