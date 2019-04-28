package JavaAnswer.six;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution506 {
    public String[] findRelativeRanks(int[] nums) {
        int[] ranks = nums.clone();
        Arrays.sort(ranks);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < ranks.length; i++) {
            map.put(ranks[i], nums.length - i);
        }
        String[] res = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int rank = map.get(nums[i]);
            String rankStr = rank + "";
            if (rank == 1) {
                rankStr = "Gold Medal";
            }
            else if (rank == 2) {
                rankStr = "Silver Medal";
            }
            else if (rank == 3) {
                rankStr = "Bronze Medal";
            }
            res[i] = rankStr;
        }
        return res;
    }
}
