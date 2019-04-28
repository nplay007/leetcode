class Solution(object):
    def canCross(self, stones):
        if stones[1] > 1: return False
        if len(stones) == 2: return True
        return self.cross(stones, 1, 1)
    
    def cross(self, stones, pos, k):
        for i in range(pos+1, len(stones)):
            gap = stones[i] - stones[pos]
            if gap < k - 1: continue
            if gap > k + 1: return False
            if self.cross(stones, i, gap): return True
        return pos == len(stones) - 1