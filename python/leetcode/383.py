class Solution(object):
    def canConstruct(self, ransomNote, magazine):
        from collections import Counter
        l1, l2 = Counter(ransomNote), Counter(magazine)
        for key, val in l1.iteritems():
            if key not in l2 or val > l2[key]:
                return False
        return True
