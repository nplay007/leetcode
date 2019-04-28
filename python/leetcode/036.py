class Solution(object):
    def isValidSudoku(self, board):
        row  = [[0] * 9 for i in range(9)]
        col  = [[0] * 9 for i in range(9)]
        cell = [[0] * 9 for i in range(9)]
        for i in xrange(9):
            for j in xrange(9):
                if board[i][j] == '.': continue 
                idx = int(board[i][j]) - 1
                k   = i / 3 * 3 + j /3
                if row[i][idx] or col[j][idx] or cell[k][idx]: 
                    return False 
                row[i][idx], col[j][idx], cell[k][idx] = 1, 1, 1
        return True