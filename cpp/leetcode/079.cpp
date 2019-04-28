class Solution {
public:
    bool exist(vector<vector<char> > &board, string word) {
        if (word.empty()) return true;
        if (board.empty() || board[0].empty()) return false;
        int m = board.size(), n = board[0].size();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (search(board, word, 0, i, j, m, n)) return true;
            }
        }
        return false;
    }
    bool search(vector<vector<char> > &board, string word, int idx, int i, int j, int m, int n) {
        if (idx == word.size()) return true;
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != word[idx]) return false;
        char tmp = board[i][j];
        board[i][j] = '#';
        bool res = search(board, word, idx + 1, i - 1, j, m, n) 
                 || search(board, word, idx + 1, i + 1, j, m, n)
                 || search(board, word, idx + 1, i, j - 1, m, n)
                 || search(board, word, idx + 1, i, j + 1, m, n);
        board[i][j] = tmp;
        return res;
    }
};