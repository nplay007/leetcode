package interview;

import java.util.Random;

public class WeightedRandom {
    public int getWeightedRandom(int[] weights) {
        int[] nums = new int[weights.length];
        int total = 0;
        for (int i = 0; i < weights.length; i++) {
            total += weights[i];
            nums[i] = total;
        }
        Random random = new Random();
        int rnd = random.nextInt(total);
        for (int i = 0; i < weights.length; i++) {
            if (rnd < nums[i]) {
                return i;
            }
        }
        return -1;
    }

    public static int randomNumber(int[] weights, int[] words) {
        if (weights == null || weights.length == 0) {
            return 0;
        }
        int n = weights.length;
        for (int i = 1; i < n; i++) {
            weights[i] += weights[i - 1];
        }
        Random rand = new Random();
        int target = rand.nextInt(weights[n - 1]);
        return binarySearch(weights, target, 0, weights.length - 1);
    }

    // binary search on weights: O(lgn)
    private static int binarySearch(int[] weights, int target, int start, int end) {
        if (weights[start] >= target) {
            return start;
        }
        int mid = start + (end - start) / 2;
        if (mid < 1) {
            return weights[start] >= target ? start : end;
        }
        if (weights[mid - 1] < target && weights[mid] >= target) {
            return mid;
        }
        if (weights[mid - 1] > target) {
            return binarySearch(weights, target, start, mid - 1);
        }
        else {
            return binarySearch(weights, target, mid + 1, end);
        }
    }
}
