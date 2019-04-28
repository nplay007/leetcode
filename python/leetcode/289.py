class Solution(object):
    def gameOfLife(self, board):
        if len(board) == 0 or len(board[0]) == 0: return
        m, n = len(board), len(board[0])
        for i in range(m):
            for j in range(n):
                nnb = self.findLiveNeighbor(board, i, j)
                if board[i][j] == 0 or board[i][j] == 2:
                    if nnb == 3: board[i][j] = 2
                else:
                    if nnb < 2 or nnb > 3: board[i][j] = 3
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2: board[i][j] = 1
                if board[i][j] == 3: board[i][j] = 0

    def findLiveNeighbor(self, board, i, j):
        count = 0
        for a, b in [(i - 1, j - 1), (i - 1, j), (i - 1, j + 1), (i + 1, j - 1), (i + 1, j), (i + 1, j + 1),
                     (i, j - 1), (i, j + 1)]:
            if 0 <= a < len(board) and 0 <= b < len(board[0]) and board[a][b] % 2 == 1:
                count += 1
        return count