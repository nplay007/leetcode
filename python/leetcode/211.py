from collections import defaultdict
class WordDictionary(object):
    def __init__(self):
        self.dict = defaultdict(list)

    def addWord(self, word):
        self.dict[len(word)].append(word)

    def search(self, word):
        if len(word) not in self.dict: return False
        for item in self.dict[len(word)]:
            for i in range(len(item)):
                if word[i] != '.'and word[i] != item[i]: break
            else:
                return True
        return False



class TrieNode:
    def __init__(self):
        self.childs = dict()
        self.isWord = False

class WordDictionary:
    def __init__(self):
        self.root = TrieNode()

    def addWord(self, word):
        node = self.root
        for ch in word:
            if ch not in node.childs:
                node.childs[ch] = TrieNode()
            node = node.childs[ch]
        node.isWord = True

    def search(self, word):
        return self.find(self.root, word)
    
    def find(self, node, word):
        if not word: return node.isWord
        if word[0] == '.':
            for child in node.childs:
                if self.find(node.childs[child], word[1:]):
                    return True
        else:
            if word[0] in node.childs:
                return self.find(node.childs[word[0]], word[1:])
        return False