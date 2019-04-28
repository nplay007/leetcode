class BinaryIndexedTree(object):
    def __init__(self, n):
        self.tree = [0] * (n + 1)
    
    def update(self, idx, val):
        while idx < len(self.tree):
            self.tree[idx] += val
            idx += idx & -idx
    
    def get(self, idx):
        s = 0
        while idx:
            s += self.tree[idx]
            idx -= idx & -idx
        return s

class Solution(object):
    def countRangeSum(self, nums, low, up):
        def build_prefix(nums):
            sums, ret = 0, []
            for elem in nums:
                sums += elem
                ret.append(sums)
            ret.insert(0, 0)
            return ret
            
        def build_bit(nums, low, up):
            pref, vals = build_prefix(nums), set()
            for e in pref:
                vals |= set([e + low, e + up, e])
            d = {v: i for i, v in enumerate(sorted(list(vals)))}
            T = BinaryIndexedTree(len(d))
            return T, d, pref

        def compute_count(T, d, pref, low, up):
            count, n = 0, len(T.tree)
            for elem in pref[::-1]:
                lb, ub = elem + low, elem + up
                count += T.get(d[ub] + 1) - T.get(d[lb])
                T.update(d[elem] + 1, 1)
            return count
    
        T, d, pref = build_bit(nums, low, up)
        return compute_count(T, d, pref, low, up)