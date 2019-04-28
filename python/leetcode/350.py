class Solution(object):
    def intersect(self, nums1, nums2):
        if not nums1 or not nums2: return []
        m, res = {}, []
        for num in nums1:
            m[num] = m.get(num, 0) + 1
        for num in nums2:
            if m.get(num, 0) > 0:
                res.append(num)
                m[num] -= 1
        return res


class Solution:
    def intersect(self, nums1, nums2):
        res = []
        i, j = 0, 0
        nums1.sort()
        nums2.sort()
        while i < len(nums1) and j < len(nums2):
            if nums1[i] == nums2[j] :
                res.append(nums1[i])
                i += 1
                j += 1
            elif nums1[i] > nums2[j]:
                j += 1
            else:
                i += 1
        return res
