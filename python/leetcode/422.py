class Solution(object):
    def validWordSquare(self, words):
        word_mat = [list(word) for word in words]
        for word in word_mat:
            word += [None]*(len(words[0])-len(word))
        word_tra = [list(i) for i in zip(*word_mat)]
        return word_mat == word_tra