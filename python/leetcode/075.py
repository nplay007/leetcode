class Solution:
    def sortColors(self, num):
        if not num:
            return
        l, r, i = 0, len(num) - 1, 0
        while i <= r:
            if num[i] == 2:
                num[i], num[r] = num[r], num[i]
                r -= 1
            elif num[i] == 0:
                num[i], num[l] = num[l], num[i]
                l += 1
                i += 1
            else:
                i += 1
