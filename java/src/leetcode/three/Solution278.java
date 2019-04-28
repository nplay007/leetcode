package JavaAnswer.three;

public class Solution278 {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (!isBadVersion(mid)) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return right;
    }

    private boolean isBadVersion(int m) {
        return true;
    }
}