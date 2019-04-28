package JavaAnswer.six;

public class Solution507 {
    public boolean checkPerfectNumber(int num) {
        if (num <= 0) {
            return false;
        }
        int res = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                res += i == num / i ? i : i + num / i;
            }
        }
        return res == 2 * num;
    }
}