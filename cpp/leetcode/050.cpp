class Solution {
public:
    double myPow(double x, int n) {
        if(n == 0) {
            return 1;
        } else if ( n < 0 ) {
            if (n == INT_MIN) {
                return 1.0 /(x * myPow(x, INT_MAX));
            } else {
                return 1.0 / myPow(x, -n);
            }
        }
        return n % 2 == 0? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }
};