package JavaAnswer.one;

public class Solution079 {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, 0, word, board)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int idx, String word, char[][] board) {
        if (idx == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(idx)) {
            return false;
        }
        char tmp = board[i][j];
        board[i][j] = '#';
        boolean result = dfs(i - 1, j, idx + 1, word, board) || dfs(i + 1, j, idx + 1, word, board) ||
                         dfs(i, j - 1, idx + 1, word, board) || dfs(i, j + 1, idx + 1, word, board);
        board[i][j] = tmp;
        return result;
    }
}