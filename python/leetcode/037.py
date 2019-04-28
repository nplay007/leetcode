class Solution(object):
    def solveSudoku(self, board):
        self.dfs(board,  0, 0)

    def check(self, board, char, row, col):
        for i in xrange(9):
            if board[row][i] == char or board[i][col] == char:
                return False
        for i in xrange(row/3*3, row/3*3+3):
            for j in xrange(col/3*3, col/3*3+3):
                if board[i][j] == char:
                    return False
        return True

    def dfs(self, board, row, col):
        if row == 9: return True
        if col == 8:
            nextRow = row + 1
            nextCol = 0
        else:
            nextRow = row
            nextCol = col+1
        if board[row][col] != '.': #occupied
            return self.dfs(board, nextRow, nextCol)
        for c in range(1, 10): # potential number
            if self.check(board, str(c), row, col):  
                board[row][col] = str(c)
                if self.dfs(board, nextRow, nextCol):  return True
                board[row][col] = '.'
        return False
