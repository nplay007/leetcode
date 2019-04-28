package JavaAnswer.one;

public class Solution004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int k = (m + n) / 2;
        if ((m + n) % 2 == 0) {
            return (findKth(nums1, 0, m, nums2, 0, n, k) +
                    findKth(nums1, 0, m, nums2, 0, n, k + 1)) / 2.0;
        }
        else {
            return findKth(nums1, 0, m, nums2, 0, n, k + 1);
        }
    }

    private double findKth(int[] nums1, int s1, int l1, int[] nums2, int s2, int l2, int k) {
        if (l1 > l2) { // to simplify the problem, suppose l2 > l1
            return findKth(nums2, s2, l2, nums1, s1, l1, k);
        }
        if (l1 == 0) { // l1 is empty
            return nums2[s2 + k - 1];
        }
        if (k == 1) { // early end condition
            return Math.min(nums1[s1], nums2[s2]);
        }

        int p1 = Math.min(l1, k / 2);
        int p2 = k - p1;
        if (nums1[s1 + p1 - 1] > nums2[s2 + p2 - 1]) { // index = length - 1
            // we drop first half of nums2, update start, length, and k
            return findKth(nums1, s1, l1, nums2, s2 + p2, l2 - p2, k - p2);
        }
        else {
            return findKth(nums1, s1 + p1, l1 - p1, nums2, s2, l2, k - p1);
        }

    }
}