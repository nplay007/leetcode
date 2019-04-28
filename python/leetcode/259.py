class Solution:
    def threeSumSmaller(self, nums, target):
        nums.sort()
        n, res = len(nums), 0
        for i in range(n - 2):
            l, r = i + 1, n - 1
            while l < r:
                if nums[i] + nums[l] + nums[r] >= target: r -= 1
                else:
                    res += r - l
                    l += 1
        return res