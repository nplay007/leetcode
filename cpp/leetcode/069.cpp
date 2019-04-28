int mySqrt(int x) {
    long r = x;
    while (r * r > x) {
        r = (r + x / r) / 2;
    }
    return r;
}

class Solution {
public:
    int mySqrt(int x) {
        long long l = 0, r = x;
        while (l <= r) {
            long long m = (r - l) / 2 + l;
            if (m * m > x) {
                r = m - 1;
            } else if (m * m == x) {
                return m;
            } else {
                l = m + 1;
            }
        }
        return r;
    }
};