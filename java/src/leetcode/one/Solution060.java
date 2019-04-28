package JavaAnswer.one;

import java.util.ArrayList;
import java.util.List;

public class Solution060 {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        int[] factor = new int[n];
        StringBuilder sb = new StringBuilder();
        factor[0] = 1;
        for (int i = 1; i < n; i++) {
            factor[i] = factor[i - 1] * i;
        }
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        k--;
        for (int i = n; i >= 1; --i) {
            int idx = k / factor[i - 1];
            sb.append(nums.get(idx));
            nums.remove(idx);
            k %= factor[i - 1];
        }
        return sb.toString();
    }
}