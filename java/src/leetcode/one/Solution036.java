package JavaAnswer.one;

public class Solution036 {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return false;
        }
        int n = board.length;
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] cell = new boolean[9][9];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    int val = Integer.valueOf(board[i][j]) - 1;
                    int k = i / 3 * 3 + j / 3;
                    if (row[i][val] || col[j][val] || cell[k][val]) {
                        return false;
                    }
                    row[i][val] = col[j][val] = cell[k][val] = true;
                }
            }
        }
        return true;
    }
}