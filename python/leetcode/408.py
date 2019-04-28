class Solution(object):
    def validWordAbbreviation(self, word, abbr):
        i, j = 0, 0
        while i < len(abbr) and j < len(word):
            if abbr[i] == word[j]:
                i += 1
                j += 1
            elif abbr[i].isdigit() and abbr[i]!='0':
                k = i
                while k <len(abbr) and abbr[k].isdigit(): k += 1
                j += int(abbr[i:k])
                i = k
            else:
                return False
        return i == len(abbr) and j == len(word)