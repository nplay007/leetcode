class Solution:
    def fullJustify(self, words, maxWidth):
        res, line, length = [], [], 0 # length: lengthber of letter
        for word in words:
            if length + len(word) + len(line) > maxWidth:  
                for i in range(maxWidth - length):
                    line[i % (len(line) - 1 or 1)] += ' '  
                res.append(''.join(line))
                line, length = [], 0
            line += [word]
            length += len(word)
        return res + [' '.join(line).ljust(maxWidth)]  