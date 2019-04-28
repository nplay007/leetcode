class Solution:
    def computeArea(self, A, B, C, D, E, F, G, H):
        left = max(A, E)
        right = max(min(C, G), left)
        bottom = max(B, F)
        top = max(min(D, H), bottom)
        return (C - A)*(D - B) - (right - left)*(top - bottom) + (G - E)*(H - F)