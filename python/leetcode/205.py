class Solution(object):
    def isIsomorphic(self, s, t):
        if len(s) != len(t):
            return False
        word1, word2 = {}, {}
        for i in range(len(s)):
            ch1, ch2 = s[i], t[i]
            if word1.get(ch1, 0) != word2.get(ch2, 0):
                return False
            word1[ch1] = i + 1
            word2[ch2] = i + 1
        return True


class Solution(object):
    def isIsomorphic(s, t):
        if len(s) != len(t):
            return False
        word = {}
        for i in range(len(s)):
            ch1, ch2 = s[i], t[i]
            if ch1 in word:
                if word[ch1] != ch2:
                    return False
            else:
                if ch2 in word.values():
                    return False
                word[ch1] = ch2
        return True
