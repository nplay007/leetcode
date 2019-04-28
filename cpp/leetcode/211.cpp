class TrieNode{
public:
    bool isWord;
    TrieNode* child[26];
    TrieNode(){
        isWord = false;
        for(auto &ptr : child) ptr = nullptr;
    }
};

class WordDictionary {
public:
    WordDictionary() {
        root = new TrieNode();
    }

    void addWord(string word) {
        TrieNode* ptr = root;
        for(auto ch : word){
            int idx = ch - 'a';
            if(!ptr->child[idx]) ptr->child[idx] = new TrieNode();
            ptr = ptr->child[idx];
        }
        ptr->isWord = true;
    }

    bool search(string word) {
        return search(0, word, root);
    }
    
    bool search(int start, string word, TrieNode *ptr){
        if(start == word.size()) return ptr->isWord;
        if(word[start] == '.'){
            for(auto node : ptr->child){
                if(node && search(start + 1, word, node)) return true;
            }
            return false;
        } else {
            int idx = word[start] - 'a';
            if(!ptr->child[idx]) return false;
            return search(start + 1, word, ptr->child[idx]);
        }
    }
private:
    TrieNode *root;
};