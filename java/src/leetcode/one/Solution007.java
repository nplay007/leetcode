package JavaAnswer.one;

public class Solution007 {
    public int reverse(int x) {
        // overflow
        long valOfReverse = 0;
        while (x != 0) {
            valOfReverse = 10 * valOfReverse + x % 10;
            x /= 10;
        }
        if (valOfReverse > Integer.MAX_VALUE || valOfReverse < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) valOfReverse;
    }
}