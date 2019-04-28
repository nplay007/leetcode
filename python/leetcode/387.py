class Solution(object):
    def firstUniqChar(self, s):
        dic = {}
        for item in s:
            dic[item] = dic.get(item, 0) + 1
        for i, item in enumerate(s):
            if dic[item] < 2: return i
        return -1

class Solution(object):
    def firstUniqChar(self, s):
        for x in s:
            if s.find(x) == s.rfind(x):
                return s.find(x)
        return -1