from collections import defaultdict

class Solution(object):
    def groupAnagrams(self, strs):
        words = defaultdict(list)
        for item in strs:
            key = "".join(sorted(item))
            words[key].append(item)
        return [sorted(val) for val in words.itervalues()]