class Solution:
    def check(self, k, j, column): 
        for i in range(k):
            if column[i] == j or abs(k - i) == abs(j - column[i]):
                return False
        return True

    def dfs(self, qnum, n, column):
        if qnum == n:
            self.res += 1
            return
        for i in range(n):
            if self.check(qnum, i, column):
                column[qnum] = i
                self.dfs(qnum + 1, n, column)

    def totalNQueens(self, n):
        self.res = 0
        column = [-1 for i in range(n)]
        self.dfs(0, n, column)
        return self.res