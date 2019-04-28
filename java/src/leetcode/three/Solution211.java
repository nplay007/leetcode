package JavaAnswer.three;

class WordDictionary {
    class TrieNode {
        boolean isWord;
        TrieNode[] children;
        TrieNode() {
            isWord = false;
            children = new TrieNode[26];
        }
    }

    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode ptr = root;
        for (char ch : word.toCharArray()) {
            if(ptr.children[ch - 'a'] == null) {
                ptr.children[ch - 'a'] = new TrieNode();
            }
            ptr = ptr.children[ch - 'a'];
        }
        ptr.isWord = true;
    }

    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        return search(0, root, word);
    }

    private boolean search(int start, TrieNode ptr, String word) {
        if (start == word.length()) {
            return ptr.isWord;
        }
        if (word.charAt(start) == '.') {
            for (TrieNode node : ptr.children) {
                if (node != null && search(start + 1, node, word)) {
                    return true;
                }
            }
            return false;
        }
        else {
            TrieNode node = ptr.children[word.charAt(start) - 'a'];
            return node == null ? false : search(start + 1, node, word);
        }
    }
}
