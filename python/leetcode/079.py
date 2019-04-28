class Solution:
    def exist(self, board, word):
        if not word: return True
        if not board or not board[0]: return False
        m, n = len(board), len(board[0])
        for i in xrange(m):
            for j in xrange(n):
                if self.dfs(board, i, j, m, n, 0, word): return True
        return False

    def dfs(self, board, i, j, m, n, idx, word):
        if len(word) == idx: return True
        if i < 0 or j < 0 or i >= m or j >= n or board[i][j] != word[idx]: return False 
        ch, board[i][j] = board[i][j], '#'
        res = self.dfs(board, i - 1, j, m, n, idx + 1, word) or \
              self.dfs(board, i + 1, j, m, n, idx + 1, word) or \
              self.dfs(board, i, j - 1, m, n, idx + 1, word) or \
              self.dfs(board, i, j + 1, m, n, idx + 1, word) 
        board[i][j] = ch
        return res