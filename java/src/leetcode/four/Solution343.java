package JavaAnswer.four;

public class Solution343 {
    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        }
        else if (n == 3) {
            return 2;
        }
        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        res *= n;
        return res;
    }
}