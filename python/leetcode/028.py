class Solution(object):
    def strStr(self, haystack, needle):
        n, m = len(haystack), len(needle)
        for i in range(n - m + 1):
            if haystack[i:i + m] == needle:
                return i
        return -1


class Solution(object):
    def strStr(self, haystack, needle):
        return haystack.find(needle)


class Solution(object):
    def strStr(self, haystack, needle):
        if not needle:
            return 0
        m, next = len(needle), [0] * len(needle)
        for i in range(1, m):
            j = next[i - 1]
            while j > 0 and needle[i] != needle[j]:
                j = next[j - 1]
            if needle[i] == needle[j]:
                next[i] = j + 1
        j = 0
        for i in range(len(haystack)):
            while j > 0 and needle[j] != haystack[i]:
                j = next[j - 1]
            if needle[j] == haystack[i]:
                j += 1
            if j == m:
                return i - m + 1
        return -1
