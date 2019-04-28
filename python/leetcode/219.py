class Solution:
    def containsNearbyDuplicate(self, nums, k):
        s = set()
        if k < 0: return False
        if k >= len(nums): k = len(nums) - 1
        for i in range(len(nums):
            if i > k: s.remove(nums[i - k - 1])
            if nums[i] in s: return True
            s.add(nums[i])
        return False

    def containsNearbyDuplicate(self, nums, k):
        dic = {}
        for i, v in enumerate(nums):
            if v in dic and i - dic[v] <= k: return True
            dic[v] = i  # just remember the most recently number
        return False