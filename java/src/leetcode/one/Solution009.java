package JavaAnswer.one;

public class Solution009 {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int y = 0;
        while (y < x) {
            y = 10 * y + x % 10;
            x /= 10;
        }
        return (y == x) || (y / 10 == x);
    }
}