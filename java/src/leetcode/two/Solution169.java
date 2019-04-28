package JavaAnswer.two;

public class Solution169 {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("invaild nums");
        }
        int cnts = 0, res = 0;
        for (int num : nums) {
            if (cnts == 0) {
                res = num;
                cnts++;
            }
            else {
                cnts += (res == num) ? 1 : -1;
            }
        }
        return res;
    }
}