package JavaAnswer.four;

public class Solution400 {
    public int findNthDigit(int n) {
        int start = 1, len = 1;
        long count = 9;
        while (n > len * count) {
            n -= len * count;
            count *= 10;
            start *= 10;
            len++;
        }
        start += (n - 1) / len;
        String res = Integer.toString(start);
        return Character.getNumericValue(res.charAt((n - 1) % len));
    }
}