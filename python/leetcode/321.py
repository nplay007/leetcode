class Solution(object):
    def maxNumber(self, nums1, nums2, k):
        def get_max_sub_array(nums, k):
            res , n = [] ,len(nums)
            for i in xrange(n):
                while res and len(res) + n - i > k and nums[i] > res[-1]:
                    res.pop()
                if len(res) < k:
                    res.append(nums[i])
            return res

        ans = [0] * k
        for i in xrange(max(0, k - len(nums2)), min(k, len(nums1)) + 1):
            res1 = get_max_sub_array(nums1, i)
            res2 = get_max_sub_array(nums2, k - i)
            ans = max(ans, [max(res1, res2).pop(0) for _ in xrange(k)])
        return ans