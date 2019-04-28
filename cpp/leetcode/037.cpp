class Solution {
public:
    void solveSudoku(vector<vector<char>>& board) {
        dfs(board, 0, 0);
    }
    
    bool check(vector<vector<char>>& board, char ch, int row, int col){
        for(int i = 0; i < 9; i++){
            if(board[row][i] == ch || board[i][col] == ch) return false;
        }
        for(int i = row/3*3; i < row/3*3 + 3; i++){
            for(int j = col/3*3; j < col/3*3+3;j++){
                if(board[i][j] == ch) return false;
            }
        }
        return true;
    }
    
    bool dfs(vector<vector<char>>& board, int row, int col){
        int nrow = -1, ncol = -1;
        if(row == 9) return true;
        if(col == 8){
            nrow = row + 1;
            ncol = 0;
        } else {
            nrow = row;
            ncol = col + 1;
        }
        if(board[row][col] != '.'){
            return dfs(board, nrow, ncol);
        }
        for(int ch = 0; ch < 9; ch++){
            if(check(board, ch + '1', row, col)){
                board[row][col] = ch + '1';
                if(dfs(board, nrow, ncol))  return true;
                board[row][col] = '.';
            }
        }
        return false;
    }
};