class Solution:
    def wiggleMaxLength(self, nums):
        if not nums: return 0
        seq, idx, n, nex = [nums[0]], 1, len(nums), -1
        ops1 = (operator.le, operator.ge)
        while idx < n:
            while idx < n and nums[idx] == seq[-1]:
                idx += 1
            if idx >= n: break
            op, nex, idx  = ops1[nums[idx] > seq[-1]], nums[idx], idx + 1
            while idx < n and op(nums[idx], nex):
                nex, idx = nums[idx], idx + 1
            seq.append(nex)
        return len(seq)