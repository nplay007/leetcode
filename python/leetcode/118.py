class Solution:
    def generate(self, numRows):
        res = [[0 for j in range(i+1)] for i in range(numRows)]
        for i in range(numRows):
            for j in range(i+1):
                if j == 0 or j == i:
                    res[i][j] = 1
                else:
                    res[i][j] = res[i-1][j]+res[i-1][j-1]
        return res