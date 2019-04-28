class Solution(object):
    def canPlaceFlowers(self, flowerbed, n):
        i, cnts, m = 0, 0, len(flowerbed)
        while i < m:
            if not flowerbed[i] and (i == 0 or not flowerbed[i-1]) and (i == m - 1 or not flowerbed[i+1]):
                flowerbed[i] = 1
                cnts += 1
                i += 1
            if cnts >= n:
                return True
            i += 1
        return False
