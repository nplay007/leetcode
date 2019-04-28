package JavaAnswer.two;

import java.util.LinkedList;
import java.util.Queue;

public class Solution130 {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ((i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (board[i][j] == 'O') {
            board[i][j] = '#';
            if (i > 1) {
                dfs(board, i - 1, j);
            }
            if (i < board.length - 1) {
                dfs(board, i + 1, j);
            }
            if (j > 1) {
                dfs(board, i, j - 1);
            }
            if (j < board[0].length - 1) {
                dfs(board, i, j + 1);
            }
        }
    }
}

class Solution130BFS {

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int m = board.length, n = board[0].length;
        int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && board[i][j] == 'O') {
                    Queue<int[]> queue = new LinkedList<>();
                    board[i][j] = '#';
                    queue.offer(new int[] { i, j });
                    while (!queue.isEmpty()) {
                        int[] point = queue.poll();
                        for (int[] dir : direction) {
                            int x = dir[0] + point[0];
                            int y = dir[1] + point[1];
                            if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O') {
                                board[x][y] = '#';
                                queue.offer(new int[] { x, y });
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
                else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}