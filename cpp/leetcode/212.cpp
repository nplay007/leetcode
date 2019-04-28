class TrieNode {
public:
    TrieNode *child[26];
    string str;
    TrieNode(){
        str = "";
        for (auto &ptr : child) ptr = NULL;
    }
};

class Trie {
public:
    TrieNode *root;
    Trie(){
        root = new TrieNode();
    }
    void insert(string word) {
        TrieNode *ptr = root;
        for (auto ch : word) {
            int i = ch - 'a';
            if (!ptr->child[i]) ptr->child[i] = new TrieNode();
            ptr = ptr->child[i];
        }
        ptr->str = word;
    }
};

class Solution {
public:
    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
        vector<string> res;
        if (words.empty() || board.empty() || board[0].empty()) return res;
        int m = board.size(), n = board[0].size();
        vector<vector<bool>> visit(m, vector<bool>(n, false));
        Trie T;
        for (auto word : words) T.insert(word);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j){
                int idx = board[i][j] - 'a';
                if (T.root->child[idx]){ 
                    search(board, T.root->child[idx], i, j, visit, res);
                }
            }
        }
        return res;
    }

    void search(vector<vector<char>> &board, TrieNode *p, int i, int j, vector<vector<bool>> &visit, vector<string> &res) { 
        if (!p->str.empty()) {
            res.push_back(p->str);
            p->str.clear();
        }
        int d[][2] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int m = board.size(), n = board[0].size();
        visit[i][j] = true;
        for (auto &a : d) {
            int nx = a[0] + i, ny = a[1] + j;
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visit[nx][ny] && p->child[board[nx][ny] - 'a']) 
                search(board, p->child[board[nx][ny] - 'a'], nx, ny, visit, res);
        }
        visit[i][j] = false;
    }
};