class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        int row[9][9] = {0}, col[9][9] = {0}, cel[9][9] = {0};
        //row[i][idx]: idx th number in ith row
        //col[i][idx]: idx th number in ith col
        //cell[i][idx]: idx th number in ith cell
        for(int i = 0; i < 9; ++i){
            for(int j = 0; j < 9; ++j){
                if(board[i][j] == '.') continue;
                int idx = board[i][j] - '0' - 1;
                int k = i / 3 * 3 + j / 3;
                if(row[i][idx] || col[idx][j] || cel[k][idx]) return false;
                row[i][idx] = col[idx][j] = cel[k][idx] = 1;
            }
        }
        return true;
    }
};