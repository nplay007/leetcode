package JavaAnswer.three;

class Trie {
    class TrieNode {
        boolean isWord;
        TrieNode[] child;

        TrieNode() {
            isWord = false;
            child = new TrieNode[256];
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode ptr = root;
        for (char ch : word.toCharArray()) {
            if (ptr.child[ch] == null) {
                ptr.child[ch] = new TrieNode();
            }
            ptr = ptr.child[ch];
        }
        ptr.isWord = true;
    }

    public boolean search(String word) {
        TrieNode ptr = root;
        for (char ch : word.toCharArray()) {
            if (ptr.child[ch] == null) {
                return false;
            }
            ptr = ptr.child[ch];
        }
        return ptr.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode ptr = root;
        for (char ch : prefix.toCharArray()) {
            if (ptr.child[ch] == null) {
                return false;
            }
            ptr = ptr.child[ch];
        }
        return true;
    }
}