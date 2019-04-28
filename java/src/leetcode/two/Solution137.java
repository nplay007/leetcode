package JavaAnswer.two;

public class Solution137 {
    public int singleNumber(int[] nums) {
        int one = 0, two = 0;
        for (int num : nums) {
            one = (one ^ num) & ~two;
            two = (two ^ num) & ~one;
        }
        return one;
    }
}


class Solution137Bit {
    public int singleNumber(int[] nums) {
        int[] cnts = new int[32];
        int res = 0;
        for (int i = 0; i < 32; i++) {
            for (int num : nums) {
                if (((num >>> i) & 1) != 0) {
                    cnts[i]++;
                }
            }
            res |= ((cnts[i] % 3) << i);
        }
        return res;
    }
}