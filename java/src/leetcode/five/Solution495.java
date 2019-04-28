package JavaAnswer.five;

public class Solution495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0 || duration == 0) {
            return 0;
        }
        int total = 0, start = timeSeries[0], end = timeSeries[0] + duration;
        for (int i = 1; i < timeSeries.length; i++) {
            if (timeSeries[i] > end) {
                total += end - start;
                start = timeSeries[i];
            }
            end = timeSeries[i] + duration;
        }
        total += end - start;
        return total;
    }
}
