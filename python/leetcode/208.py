class TrieNode:
    def __init__(self):
        self.word = False
        self.child = {}

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        node = self.root
        for ch in word:
            if ch not in node.child:
                node.child[ch] = TrieNode()
            node = node.child[ch]
        node.word = True

    def search(self, word):
        node = self.root
        for ch in word:
            if ch not in node.child: return False
            node = node.child[ch]
        return node.word

    def startsWith(self, prefix):
        node = self.root
        for ch in prefix:
            if ch not in node.child: return False
            node = node.child[ch]
        return True