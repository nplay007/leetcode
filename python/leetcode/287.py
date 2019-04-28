class Solution(Thread):
    def findDuplicate(self, nums):
        sl, fast = nums[0], nums[nums[0]]
        while (sl != fast):
            sl = nums[sl]
            fast = nums[nums[fast]]
        fast = 0;
        while (fast != sl):
            fast = nums[fast]
            sl = nums[sl]
        return sl


def findDuplicate2(self, nums):
    l, r = 1, len(nums)-1
    while l < r:
        mid = l+(r-l)/2
        cnts = 0
        for num in nums:
            if num <= mid: cnts += 1
        if cnts <= mid: l = mid + 1
        else: r = mid
    return l
