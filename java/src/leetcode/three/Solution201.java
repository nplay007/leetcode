package JavaAnswer.three;

public class Solution201 {
    public int rangeBitwiseAnd(int m, int n) {
        int result = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            result++;
        }
        return n << result;
    }
}