package JavaAnswer.two;

public class Solution191 {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }
}


class Solution191II {
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}