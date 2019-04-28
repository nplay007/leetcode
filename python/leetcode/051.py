class Solution:
    def check(self, k, j, column):  
        # check if the kth queen can be put in column j
        # column[i] == j: already exist
        # |k - i| == |j - column[i]| one line
        for i in range(k):
            if column[i] == j or abs(k - i) == abs(j - column[i]):
                return False
        return True
 
    def dfs(self, qnum, n, column, ans, res):
        if qnum == n:
            res.append(ans)
            return
        for i in range(n): 
            # i represent ith col, qnum is qth Queen 
            if self.check(qnum, i, column):
                column[qnum] = i
                s = '.' * i + 'Q' + '.' * (n - i - 1)
                self.dfs(qnum + 1, n, column, ans+[s], res)

    def solveNQueens(self, n):
        column = [-1 for i in range(n)]  # column number of each Queen
        res = []
        self.dfs(0, n, column, [], res)
        return res