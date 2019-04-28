class TrieNode {
public:
    TrieNode *child[26];
    bool isWord;
    TrieNode(){
        isWord = false;
        for (auto &ptr : child) ptr = NULL; // necessary
    }
};

class Trie {
public:
    Trie() { root = new TrieNode();}

    void insert(string word) {
        TrieNode *ptr = root;
        for (auto ch : word) {
            int i = ch - 'a';
            if (!ptr->child[i]) ptr->child[i] = new TrieNode();
            ptr = ptr->child[i];
        }
        ptr->isWord = true;
    }

    bool search(string word) {
        TrieNode *ptr = root;
        for (auto ch : word) {
            int i = ch - 'a';
            if (!ptr->child[i]) return false;
            ptr = ptr->child[i];
        }
        return ptr->isWord;
    }

    bool startsWith(string prefix) {
        TrieNode *ptr = root;
        for (auto ch : prefix) {
            int i = ch - 'a';
            if (!ptr->child[i]) return false;
            ptr = ptr->child[i];
        }
        return true;
    }

private:
    TrieNode* root;
};