class Solution:
    def trap(self, height):
        l , r = 0, len(height) - 1
        total, pillar, h = 0, 0, 0
        while l <= r:
            tmp = min(height[l], height[r])
            total += (r - l + 1) * (tmp - h) if tmp > h else 0
            pillar += tmp
            h = max(h, tmp)
            if height[l] == tmp:
                l += 1
            else:
                r -= 1
        return total - pillar