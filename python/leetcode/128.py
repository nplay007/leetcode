class Solution:
    def longestConsecutive(self, nums):
        nums = set(nums)
        ans = 0
        for num in nums:
            if num - 1 not in nums:
                m = num + 1
                while m in nums:
                    m += 1
                ans = max(ans, m - num)
        return ans



class Solution:
    def longestConsecutive(self, nums):
        res = 1
        ans = {}
        for n in nums:
            if n not in ans:
                left = ans.get(n-1, 0)
                right = ans.get(n+1, 0)
                total = left + right + 1
                ans[n] = total
                res = max(res, total)
                ans[n - left] = total
                ans[n + right] = total
        return res

