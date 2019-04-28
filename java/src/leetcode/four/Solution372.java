package JavaAnswer.four;

public class Solution372 {
    public int superPow(int a, int[] b) {
        long res = 1;
        for (int num : b) {
            res = pow(res, 10) * pow(a, num) % 1337;
        }
        return (int) res;
    }

    public long pow(long num, int n) {
        if (n == 0) {
            return 1;
        }
        else if (n == 1) {
            return num % 1337;
        }
        return pow(num, n / 2) * pow(num, n - n / 2) % 1337;
    }
}