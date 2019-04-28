class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        m, n = len(nums1), len(nums2)
        if (m + n) % 2 != 0:
            return self.getKth(nums1, nums2, (m + n) / 2 + 1)
        else:
            return (self.getKth(nums1, nums2, (m + n) / 2) + self.getKth(nums1, nums2, (m + n) / 2 + 1)) / 2.0

    def getKth(self, nums1, nums2, k):
        m, n = len(nums1), len(nums2)
        if m > n:
            return self.getKth(nums2, nums1, k)
        if m == 0:
            return nums2[k - 1]
        if k == 1:
            return min(nums1[0], nums2[0])
        idxOfNum1 = min(m, k / 2)
        idxOfNum2 = k - idxOfNum1
        if nums1[idxOfNum1 - 1] < nums2[idxOfNum2 - 1]:
            return self.getKth(nums1[idxOfNum1:], nums2, idxOfNum2)
        else:
            return self.getKth(nums1, nums2[idxOfNum2:],  idxOfNum1)
