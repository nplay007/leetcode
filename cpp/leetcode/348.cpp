class TicTacToe {
public:
    /** Initialize your data structure here. */
    TicTacToe(int n) {
        board.resize(n, vector<int>(n, 0));   
    }

    int move(int row, int col, int player) {
        board[row][col] = player;
        int i = 0, j = 0, N = board.size();
        for (i = 0; i < N; ++i) {
            if (board[i][0] != 0) {
                for (j = 1; j < N; ++j) {
                    if (board[i][j] != board[i][j - 1]) break;
                }
                if (j == N) return board[i][0];
            }
        }
        for (j = 0; j < N; ++j) {
            if (board[0][j] != 0) {
                for (i = 1; i < N; ++i) {
                    if (board[i][j] != board[i - 1][j]) break;
                }
                if (i == N) return board[0][j];
            }
        }
        if (board[0][0] != 0) {
            for (i = 1; i < N; ++i) {
                if (board[i][i] != board[i - 1][i - 1]) break;
            }
            if (i == N) return board[0][0];
        }
        if (board[N - 1][0] != 0) {
            for (i = 1; i < N; ++i) {
                if (board[N - i - 1][i] != board[N - i][i - 1]) break;
            }
            if (i == N) return board[N - 1][0];
        }
        return 0;
    }
    
private:
    vector<vector<int>> board;
};



class TicTacToe {
public:
    /** Initialize your data structure here. */
    TicTacToe(int n): rows(n), cols(n), N(n), diag(0), rev_diag(0) {}

    int move(int row, int col, int player) {
        int add = player == 1 ? 1 : -1;
        rows[row] += add; cols[col] += add;
        diag += (row == col ? add : 0);
        rev_diag += (row == N - col - 1 ? add : 0);
        return (abs(rows[row]) == N || abs(cols[col]) == N || abs(diag) == N || abs(rev_diag) == N) ? player : 0;
    }

private:
    vector<int> rows, cols;
    int diag, rev_diag, N;
};