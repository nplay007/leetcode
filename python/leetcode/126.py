class Solution:
    def backtrack(self, res, trace, path, word):
        if len(trace[word]) == 0:
            res.append([word] + path)
        else:
            for prev in trace[word]:
                self.backtrack(res, trace, [word] + path, prev)
                
    def findLadders(self, start, end, wordList):
        res, trace, current = [], {word: [] for word in wordList}, set([start])
        while current and end not in current:
            for word in current: wordList.remove(word)
            next = set([])
            for word in current:
                for i in range(len(word)):
                    for j in 'abcdefghijklmnopqrstuvwxyz':
                        candidate = word[:i] + j + word[i + 1:]
                        if candidate in wordList:
                            trace[candidate].append(word)
                            next.add(candidate)
            current = next
        if current: self.backtrack(res, trace, [], end)
        return res