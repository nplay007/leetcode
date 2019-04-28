package JavaAnswer.one;

public class Solution069 {
    public int mySqrt(int x) {
        long r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }
}

class Solution069Addtional {
    public int mySqrt(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("Invalid number.");
        }
        long left = 0, right = x;
        while (left <= right) {
            long m = (right - left) / 2 + left;
            if (m * m == x) {
                return (int) m;
            }
            else if (m * m > x) {
                right = m - 1;
            }
            else {
                left = m + 1;
            }
        }
        return (int) right;
    }
}