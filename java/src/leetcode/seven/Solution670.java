package JavaAnswer.seven;

public class Solution670 {
    public int maximumSwap(int num) {
        char[] nums = String.valueOf(num).toCharArray();
        int[] last = new int[10]; // last index of digit
        for (int i = 0; i < nums.length; i++) {
            last[nums[i] - '0'] = i;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 9; j > nums[i] - '0'; j--) { // early stop
                if (last[j] > i) {
                    char tmp = nums[i];
                    nums[i] = nums[last[j]];
                    nums[last[j]] = tmp;
                    return Integer.valueOf(new String(nums));
                }
            }
        }
        return num;
    }
}