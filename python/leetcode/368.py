class Solution:
    def largestDivisibleSubset(self, nums):
        if not nums: return []
        nums.sort(reverse = True)
        n, curMax, k = len(nums), 1, 0
        par, dp, res = [0] * n, [1] * n, []
        for i in range(n): par[i] = i
        for i in range(n):
            for j in range(i):
                if nums[j] % nums[i] != 0: continue
                if dp[i] < dp[j]+1:
                    par[i] = j
                    dp[i] = dp[j]+1
                if dp[i] > curMax:
                    curMax = dp[i]
                    k = i
        while par[k] != k:
            res.append(nums[k])
            k = par[k]
        res.append(nums[k])
        return res