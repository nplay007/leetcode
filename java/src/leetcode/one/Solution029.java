package JavaAnswer.one;

public class Solution029 {
    public int divide(int dividend, int divisor) {
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        long res = 0;
        while (dvd >= dvs) {
            long tmp = dvs;
            long count = 1;
            while (dvd >= (tmp << 1)) {
                tmp <<= 1;
                count <<= 1;
            }
            dvd -= tmp;
            res += count;
        }
        if (res * sign > Integer.MAX_VALUE || res * sign < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) (res * sign);
    }
}