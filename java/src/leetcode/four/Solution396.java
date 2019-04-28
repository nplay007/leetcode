package JavaAnswer.four;

public class Solution396 {
    public int maxRotateFunction(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int rotateSum = 0;
        int sum = 0;
        int n = A.length;
        for (int i = 0; i < n; i++) {
            sum += A[i];
            rotateSum += i * A[i];
        }
        int maxRotateSum = rotateSum; // all negative
        for (int i = n - 1; i > 0; i--) {
            rotateSum += sum - n * A[i];
            maxRotateSum = Math.max(maxRotateSum, rotateSum);
        }
        return maxRotateSum;
    }
}