class Solution:
    def multiply(self, num1, num2):
        n, m = len(num1), len(num2)
        ans = [0 for i in range(n + m)]
        for i in range(n - 1, -1, -1):
            for j in range(m - 1, -1, -1):
                mul = int(num1[i]) * int(num2[j])
                idx1 = i + j
                idx2 = i + j + 1
                ans[idx1] += (mul + ans[idx2]) / 10
                ans[idx2] = (mul + ans[idx2]) % 10
        res =  ''.join(map(str, ans)).lstrip("0")
        return res if res else "0"