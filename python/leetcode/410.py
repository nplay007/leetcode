class Solution(object):
    def splitArray(self, nums, m):
        def valid(mid):
            cnt, cur = 0, 0
            for n in nums:
                cur += n
                if cur>mid:
                    cnt += 1
                    if cnt>=m: return False
                    cur = n
            return True

        l, h = max(nums), sum(nums)
        while l<h:
            mid = l+(h-l)/2
            if valid(mid): h = mid
            else: l = mid+1
        return l