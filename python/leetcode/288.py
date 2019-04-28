import collections
class ValidWordAbbr(object):
    def __init__(self, dictionary):
        self.dic = collections.defaultdict(set)
        for word in dictionary:
            abbr = word if len(word) <= 2 else word[0] + str(len(word)-2) + word[-1]
            self.dic[abbr].add(word)

    def isUnique(self, word):
        abbr = word if len(word) <= 2 else word[0] + str(len(word)-2) + word[-1]
        return len(self.dic[abbr]) == 0 or (len(self.dic[abbr]) == 1 and word == list(self.dic[abbr])[0])