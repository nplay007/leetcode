#include <iostream>

using namespace std;
class Solution {
public:
    void solve(vector<vector<char>>& board) {
        if(board.empty() || board[0].empty()) return ;
        int m = board.size(), n = board[0].size();
        for(int i = 0; i < m; i++){
            if(board[i][0] == 'O') dfs(i, 0, board);
            if(board[i][n-1] == 'O') dfs(i, n-1, board);
        }
        for(int i = 0; i < n; i++){
            if(board[0][i] == 'O') dfs(0, i, board);
            if(board[m-1][i] == 'O') dfs(m-1, i, board);
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }

    void dfs(int i, int j, vector<vector<char>> & board){
        int m = board.size(), n = board[0].size();
        if(board[i][j] == 'O') board[i][j] = '#';
        if(i > 1 && board[i-1][j] == 'O') dfs(i-1, j, board); // i > 0
        if(i < m-1 && board[i+1][j] == 'O') dfs(i+1, j, board);
        if(j > 1 && board[i][j-1] == 'O') dfs(i, j-1, board); // j > 0
        if(j < n-1 && board[i][j+1] == 'O') dfs(i, j+1, board);
    }
};