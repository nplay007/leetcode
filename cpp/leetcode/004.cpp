class Solution {
public:
    int getKth(vector<int> &nums1, vector<int> &nums2, int k) {
        int m = nums1.size();
        int n = nums2.size();
        if (m > n) {
            return getKth(nums2, nums1, k);
        }
        if (m == 0) {
            return nums2[k - 1];
        }
        if (k == 1) {
            return min(nums1[0], nums2[0]);
        }
        int pa = min(k / 2, m), pb = k - pa;
        if (nums1[pa - 1] < nums2[pb - 1]) {
            vector<int> tmp(nums1.begin() + pa, nums1.end());
            return getKth(tmp, nums2, k - pa);
        } else {
            vector<int> tmp(nums2.begin() + pb, nums2.end());
            return getKth(nums1, tmp, k - pb);
        }
    }

    double findMedigetKthortedArrays(vector<int> &nums1, vector<int> &nums2) {
        int m = nums1.size(), n = nums2.size();
        int k = (n + m) / 2;
        if ((m + n) % 2 != 0) {
            return getKth(nums1, nums2, k + 1);
        } else {
            return (getKth(nums1, nums2, k) + getKth(nums1, nums2, k + 1)) / 2.0;
        }
    }
};