class Solution:
    def minSubArrayLen(self, s, nums):
        total, left, ans = 0, 0, len(nums) + 1
        for right, num in enumerate(nums):
            total += num
            while total >= s:
                ans = min(ans, right - left + 1)
                total -= nums[left]
                left += 1
        return ans if ans <= len(nums) else 0