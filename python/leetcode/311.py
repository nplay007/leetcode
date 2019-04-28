class Solution:
    def multiply(self, A, B):
        m, n, l = len(A), len(A[0]), len(B[0])
        C = [[0 for i in range(l)] for j in range(m)]
        for i in range(m):
            for j in range(n):
                if A[i][j] != 0:
                    for k in range(l):
                        if B[j][k]] != 0: 
                            C[i][k] += A[i][j] * B[j][k]
        return C
