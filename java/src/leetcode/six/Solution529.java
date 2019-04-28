package JavaAnswer.six;

import java.util.LinkedList;
import java.util.Queue;

public class Solution529 {
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length, n = board[0].length;
        int row = click[0], col = click[1];
        if (board[row][col] == 'M') { // Mine
            board[row][col] = 'X';
        }
        else {
            // Get number of mines first.
            int count = 0;
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    int x = row + i, y = col + j;
                    if (x < 0 || x >= m || y < 0 || y < 0 || y >= n) {
                        continue;
                    }
                    if (board[x][y] == 'M' || board[x][y] == 'X') {
                        count++;
                    }
                }
            }
            if (count > 0) { // If it is not a 'B', stop further DFS.
                board[row][col] = (char) (count + '0');
            }
            else { // Continue DFS to adjacent cells.
                board[row][col] = 'B';
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if (i == 0 && j == 0) {
                            continue;
                        }
                        int x = row + i, y = col + j;
                        if (x < 0 || x >= m || y < 0 || y < 0 || y >= n) {
                            continue;
                        }
                        if (board[x][y] == 'E') {
                            updateBoard(board, new int[] { x, y });
                        }
                    }
                }
            }
        }
        return board;
    }
}





class Solution529BFS {
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length, n = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(click);
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1];
            if (board[row][col] == 'M') { // Mine
                board[row][col] = 'X';
            }
            else {
               // Get number of mines first.
                int count = 0;
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if (i == 0 && j == 0) {
                            continue;
                        }
                        int r = row + i, c = col + j;
                        if (r < 0 || r >= m || c < 0 || c < 0 || c >= n) {
                            continue;
                        }
                        if (board[r][c] == 'M' || board[r][c] == 'X') {
                            count++;
                        }
                    }
                }
                if (count > 0) { // If it is not a 'B', stop further BFS.
                    board[row][col] = (char) (count + '0');
                }
                else { // Continue BFS to adjacent cells.
                    board[row][col] = 'B';
                    for (int i = -1; i < 2; i++) {
                        for (int j = -1; j < 2; j++) {
                            if (i == 0 && j == 0) {
                                continue;
                            }
                            int r = row + i, c = col + j;
                            if (r < 0 || r >= m || c < 0 || c < 0 || c >= n) {
                                continue;
                            }
                            if (board[r][c] == 'E') {
                                queue.add(new int[] { r, c });
                                board[r][c] = 'B'; // Avoid to be added again.
                            }
                        }
                    }
                }
            }
        }
        return board;
    }
}