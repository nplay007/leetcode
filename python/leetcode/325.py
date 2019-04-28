class Solution:
    def maxSubArrayLen(self, nums, k):
        if not nums:
            return 0
        arraySum = {0: -1}
        sums, max_len = 0, 0
        for i in range(len(nums)):
            sums += nums[i]
            if sums not in arraySum:
                arraySum[sums] = i
            if sums - k in arraySum:
                idx = arraySum[sums - k]
                max_len = max(max_len, i - idx)
        return max_len
