class Solution:
    def ladderLength(self, beginWord, endWord, WordList):
        from collections import deque
        from string import ascii_lowercase
        WordList.add(endWord)
        n = len(beginWord)
        queue = deque([(beginWord, 1)])
        while queue:
            word, res = queue.popleft()
            if word == endWord: return res
            for i in xrange(n):
                for ch in ascii_lowercase:
                    if word[i] == ch: continue
                    new = word[:i] + ch + word[i+1:]
                    if new in WordList:
                        queue.append((new, res + 1))
                        WordList.remove(new)
        
        return 0