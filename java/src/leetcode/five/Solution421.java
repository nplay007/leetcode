package JavaAnswer.five;

import java.util.HashSet;
import java.util.Set;

public class Solution421 {
    public int findMaximumXOR(int[] nums) {
        int res = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & mask); // reserve Left bits and ignore Right bits
            }
            // in each iteration, there are pair(s) whose Left bits can XOR to max
            int tmp = res | (1 << i);
            for (int prefix : set) {
                if (set.contains(tmp ^ prefix)) {
                    res = tmp;
                }
            }
        }
        return res;
    }
}
