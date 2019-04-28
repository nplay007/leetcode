package JavaAnswer.three;

public class Solution204 {
    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }
        boolean[] prime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!prime[i]) {
                count++;
                for (int j = 2; j * i < n; j++) {
                    prime[j * i] = true;
                }
            }
        }
        return count;
    }
}