class Solution:
    def sortTransformedArray(self, nums, a, b, c):
        n, i, j = len(nums), 0, len(nums) - 1
        res = [0] * n
        idx = n - 1 if a >= 0 else 0
        while i <= j:
            if a >= 0:
                if self.cal(nums[i], a, b, c) >= self.cal(nums[j], a, b, c):
                    res[idx] = self.cal(nums[i], a, b, c)
                    i += 1
                else:
                    res[idx] = self.cal(nums[j], a, b, c)
                    j -= 1
                idx -= 1
            else:
                if self.cal(nums[i], a, b, c) >= self.cal(nums[j], a, b, c):
                    res[idx] = self.cal(nums[j], a, b, c)
                    j -= 1
                else:
                    res[idx] = self.cal(nums[i], a, b, c)
                    i += 1
                idx += 1
        return res

    def cal(self, x, a, b, c):
        return a * x * x + b * x + c