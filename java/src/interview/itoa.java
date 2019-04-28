package interview;

public class itoa {
    public String getItoa(int num, int base) {
        StringBuilder res = new StringBuilder("");
        boolean sign = false;
        if (num == 0) {
            return "0";
        }
        else if (num < 0) {
            num = -num;
            sign = true;
        }
        while (num != 0) {
            int ans = num % base;
            char ch = (char) (ans > 9 ? (ans - 10 + 'a') : (ans + '0'));
            num /= base;
            res.append(ch);
        }
        if (sign) {
            res.append('-');
        }
        return res.reverse().toString();
    }
}