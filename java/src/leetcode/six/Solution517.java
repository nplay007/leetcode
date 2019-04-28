package JavaAnswer.six;

public class Solution517 {
    public int findMinMoves(int[] machines) {
        int total = 0;
        for (int machine : machines) {
            total += machine;
        }
        if (total % machines.length != 0) {
            return -1;
        }
        int avg = total / machines.length;
        int count = 0; // accumulated gain or loss
        int result = 0;
        for (int machine : machines) {
            count += machine - avg; // gain or lose
            result = Math.max(Math.max(result, Math.abs(count)), machine - avg);
        }
        return result;
    }
}
