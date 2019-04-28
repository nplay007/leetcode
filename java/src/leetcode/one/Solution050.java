package JavaAnswer.one;

public class Solution050 {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return 1.0 / x / myPow(x, Integer.MAX_VALUE);
            }
            return 1.0 / myPow(x, -n);
        }
        else {
            return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
        }
    }
}