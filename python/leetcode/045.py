class Solution(object):
    def jump(self, nums):
        reach, step, cur = 0, 0, 0
        for idx, val in enumerate(nums):
            if idx > reach:
                step += 1
                reach = cur
            cur = max(cur, idx + val)
        return step