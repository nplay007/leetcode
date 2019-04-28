class Solution(object):
    def maxSumSubmatrix(self, matrix, k):
        m = len(matrix)
        n = len(matrix[0]) if m else 0
        M, N, ans = max(m, n), min(m, n), None
        for x in range(N):
            sums = [0] * M
            for y in range(x, N):
                slist, num = [], 0
                for z in range(M):
                    sums[z] += matrix[z][y] if m > n else matrix[y][z]
                    num += sums[z]
                    if num <= k: ans = max(ans, num)
                    i = bisect.bisect_left(slist, num - k)
                    if i != len(slist): ans = max(ans, num - slist[i])
                    bisect.insort(slist, num)
        return ans or 0