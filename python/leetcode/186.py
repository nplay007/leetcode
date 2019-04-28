class Solution:
    def reverseWords(self, s):
        self.reverse(s, 0, len(s))
        i = 0
        for j in range(len(s)):
            if j == len(s) or s[j] == ' ':
                self.reverse(s, i, j)
                i =  j + 1

    def reverse(self, s, begin, end):
        for i in range((end - begin)/2):
            s[begin+i], s[end-i-1]= s[end-i-1], s[begin+i]


class Solution(object):
    def reverseWords(self, s):
        s[:] = list(' '.join(reversed(''.join(s).split(' '))))