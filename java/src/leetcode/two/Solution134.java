package JavaAnswer.two;

public class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0, total = 0, idx = 0;
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                idx = i + 1;
                tank = 0;
            }
            total += gas[i] - cost[i];
        }
        if (total < 0) {
            return -1;
        }
        return idx;
    }
}