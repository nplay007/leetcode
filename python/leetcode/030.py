class Solution(object):
    def findSubstring(self, s, words):
        n, m = len(words), len(words[0])  # m word length
        cnts, res = {}, []   # total words length
        for word in words:
            cnts[word] = cnts.get(word, 0) + 1
        for i in range(len(s) - m * n + 1):
            j, cur = 0, {}
            while j < n:
                word = s[i + j * m: i + (j + 1) * m]
                if word not in cnts:
                    break
                cur[word] = cur.get(word, 0) + 1
                if cur[word] > cnts[word]:
                    break
                j += 1
            if j == n:
                res.append(i)
        return res
